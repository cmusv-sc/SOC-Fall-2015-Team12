/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.PostSet;
import models.metadata.ClimateService;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.APICall;
import util.APICall.ResponseType;
import views.html.climate.HomePage;
import views.html.climate.MainPage;

public class HomePageController extends Controller {
	public static Result homepage() throws Exception {
		return ok(HomePage.render(PostSet.all()));
	}

	public static Result editPost() {

		ObjectNode jsonData = Json.newObject();
		try {
			DynamicForm df = DynamicForm.form().bindFromRequest();
			String postId = df.field("pk").value();

			if (postId != null && !postId.isEmpty()) {
				jsonData.put("postId", postId);
			}
			PostSet originalPost = PostSet.findPostById(postId);

			if (originalPost == null) {
				Application.flashMsg(APICall.createResponse(ResponseType.UNKNOWN));
				return notFound("not found original post " + originalPost);
			}

			jsonData.put("id", Integer.parseInt(originalPost.getPostId()));
			jsonData.put("userId", originalPost.getUserId());
			jsonData.put("text", originalPost.getPostText());
			jsonData.put("privacy", originalPost.getPostStatus());
			jsonData.put("time", String.valueOf(originalPost.getPostTime()));

			String editField = df.field("name").value();
			if (editField != null && !editField.isEmpty()) {
				jsonData.put(editField, df.field("value").value());
				System.out.println(editField);
				System.out.println(df.field("value").value());
			}
			if (editField == null || editField.isEmpty()) {
				Application.flashMsg(APICall.createResponse(ResponseType.UNKNOWN));
				return notFound("not found edit field");
			}

			// Call the edit() method
			System.out.println(postId);
			JsonNode response = ClimateService.edit(postId, jsonData);

			// flash the response message
			Application.flashMsg(response);

		} catch (IllegalStateException e) {
			e.printStackTrace();
			Application.flashMsg(APICall
					.createResponse(ResponseType.CONVERSIONERROR));
		} catch (Exception e) {
			e.printStackTrace();
			Application.flashMsg(APICall.createResponse(ResponseType.UNKNOWN));
		}
		return ok("updated");

	}

}
