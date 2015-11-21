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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.PostSet;
import models.metadata.ClimateService;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.APICall;
import util.APICall.ResponseType;

import util.Constants;
import views.html.climate.*;

import java.util.List;

public class MainPageController extends Controller {

	final static Form<PostSet> postsetForm = Form
			.form(PostSet.class);

	public static Result mainpage() throws Exception {
		return ok(MainPage.render(PostSet.self("123456"),postsetForm));
	}

	public static Result editPost() {

		ObjectNode jsonData = Json.newObject();
		try {
			DynamicForm df = DynamicForm.form().bindFromRequest();
			String postId = df.field("pk").value();

			if (postId != null && !postId.isEmpty()) {
				jsonData.put("id", postId);
			}
			PostSet originalPost = PostSet.findPostById(postId);

			if (originalPost == null) {
				Application.flashMsg(APICall.createResponse(ResponseType.UNKNOWN));
				return notFound("not found original post " + originalPost);
			}

			jsonData.put("id", Integer.parseInt(originalPost.getPostId()));
			jsonData.put("userId", originalPost.getUserId());
			String status = "";
			if (originalPost.getPostStatus().contains("Private")) {
				status = "1";
			} else {
				status = "0";
			}
			jsonData.put("privacy", status);
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

	public static Result deletePost() throws Exception{
		DynamicForm df = DynamicForm.form().bindFromRequest();
		String postId = df.field("idHolder").value();
//		Integer tempId = Integer.parseInt(postId);
		System.out.println("Will delete: " + postId);
		Logger.debug(postId);



		// return a text message

		// Call the delete() method
		JsonNode response = ClimateService.delete(postId);

		// flash the response message
		Application.flashMsg(response);

		return redirect("/mainpage");
	}

	public static Result createNewPost() throws Exception{

		Form<PostSet> nu = postsetForm.bindFromRequest();
//		ObjectNode jsonData = Json.newObject();
//		String userName = null;
//
		System.out.println(nu.get().getPostText());

		String userId = "123456";
		String postId = nu.get().getPostId();







		String postText = nu.get().getPostText();
		String postStatus = nu.get().getPostStatus2();
//		String postTime = nu.get().getPostTime().toString();
//
//		List<PostSet> res = PostSet.addPost(userId, postId, postText, postStatus);

//		return ok(MainPage.render(res, postsetForm));

		ObjectNode jsonData = Json.newObject();
		try {
			DynamicForm df = DynamicForm.form().bindFromRequest();
			jsonData.put("userId", userId);
			jsonData.put("text", postText);
			jsonData.put("privacy", postStatus);
//			jsonData.put("PostTime", String.valueOf(originalPost.getPostTime()));

			JsonNode response =   APICall.postAPI(Constants.NEW_BACKEND + "posts/add", jsonData);
			//Application.flashMsg(response);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			Application.flashMsg(APICall
					.createResponse(ResponseType.CONVERSIONERROR));
		} catch (Exception e) {
			e.printStackTrace();
			Application.flashMsg(APICall.createResponse(ResponseType.UNKNOWN));
		}

		return redirect("/mainpage");


//		return ok("ID: "+ nu.get().getPostId()
//				+ "\nText: " + nu.get().getPostText()
//				+"\nStatus: "+nu.get().getPostStatus()+
//				"\nPost time: "+nu.get().getPostTime());


/*		try{
			jsonData.put("postID", "123456");
			jsonData.put("postText", nu.get().getPostText());
			jsonData.put("postStatus", nu.get().getPostStatus());
			jsonData.put("userID", "12345678");


//			JsonNode response = APICall.postAPI(Constants.URL_HOST + Constants.CMU_BACKEND_PORT
//					+ Constants.ADD_USER, jsonData);

			// flash the response message
			Application.flashMsg(response);
			return redirect(routes.Application.createSuccess());

		}catch (IllegalStateException e) {
			e.printStackTrace();
			Application.flashMsg(APICall
					.createResponse(ResponseType.CONVERSIONERROR));
		} catch (Exception e) {
			e.printStackTrace();
			Application.flashMsg(APICall
					.createResponse(ResponseType.UNKNOWN));
		}*/
//		return ok(signup.render(nu));


//		return ok(MainPage.render(PostSet.example(), postsetForm));

	}

}
