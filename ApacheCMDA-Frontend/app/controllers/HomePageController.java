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
import play.Logger;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import util.APICall;
import util.APICall.ResponseType;
import util.Constants;
import views.html.climate.HomePage;
import views.html.climate.MainPage;
import views.html.climate.topPosts;

public class HomePageController extends Controller {
	static int currentPublicPager;
	final static Form<PostSet> postsetForm = Form
			.form(PostSet.class);

	public static Result homepage() throws Exception {
		currentPublicPager = 1;
		System.out.println("Current public page: " + currentPublicPager);
		String userId = session().get("userId");
		return ok(HomePage.render(PostSet.all(userId, currentPublicPager), postsetForm));

//		String userId = session().get("userId");
//		return ok(HomePage.render(PostSet.all(userId), postsetForm));
	}

	public static Result previousPage() throws Exception {
		if (currentPublicPager > 1) {
			currentPublicPager--;
		}
		System.out.println("Current public page: " + currentPublicPager);
		String userId = session().get("userId");
		return ok(HomePage.render(PostSet.all(userId, currentPublicPager), postsetForm));
	}

	public static Result nextPage() throws Exception {
		currentPublicPager++;
		System.out.println("Current public page: " + currentPublicPager);
		String userId = session().get("userId");
		return ok(HomePage.render(PostSet.all(userId, currentPublicPager), postsetForm));
	}

	public static Result topPosts() throws Exception {
		String userId = session().get("userId");
		return ok(topPosts.render(PostSet.top(userId)));
	}

	public static Result editPost() {

		ObjectNode jsonData = Json.newObject();
		try {
			DynamicForm df = DynamicForm.form().bindFromRequest();
			String postId = df.field("pk").value();
			String userId = session().get("userId");

			if (postId != null && !postId.isEmpty()) {
				jsonData.put("postId", postId);
			}
			PostSet originalPost = PostSet.findPostById(postId, userId);

			if (originalPost == null) {
				Application.flashMsg(APICall.createResponse(ResponseType.UNKNOWN));
				return notFound("not found original post " + originalPost);
			}

			jsonData.put("id", Integer.parseInt(originalPost.getPostId()));
			jsonData.put("userId", originalPost.getUserId());
			jsonData.put("text", originalPost.getPostTextS());
			jsonData.put("privacy", originalPost.getPostStatusS());
			jsonData.put("time", String.valueOf(originalPost.getPostTimeS()));

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

	public static Result likePost() throws Exception{
		DynamicForm df = DynamicForm.form().bindFromRequest();
		String postId = df.field("idHolder").value();
		String userId = session().get("userId");
//		Integer tempId = Integer.parseInt(postId);
		System.out.println(userId + " Will like: " + postId);
		Logger.debug(postId);

		// return a text message

		// Call the delete() method

//		JsonNode response = ClimateService.delete(postId);

//		Application.flashMsg(response);
		ObjectNode jsonData = Json.newObject();
		try {
			jsonData.put("userId", userId);
			jsonData.put("postId", postId);
//			jsonData.put("privacy", postStatus);
//			jsonData.put("PostTime", String.valueOf(originalPost.getPostTime()));

			JsonNode response =   APICall.postAPI(Constants.NEW_BACKEND + "likes/add", jsonData);
			//Application.flashMsg(response);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			Application.flashMsg(APICall
					.createResponse(ResponseType.CONVERSIONERROR));
		} catch (Exception e) {
			e.printStackTrace();
			Application.flashMsg(APICall.createResponse(ResponseType.UNKNOWN));
		}

		return redirect("/homepage");
	}

	public static Result sharePost() throws Exception{
		DynamicForm df = DynamicForm.form().bindFromRequest();
//		String userEmail = session().get("email");
		String postId = df.field("idHolder").value();
//		String postText = userEmail + " shared: " + df.field("textHolder").value();
		String userId = session().get("userId");
//		String postStatus = "0";

//		Integer tempId = Integer.parseInt(postId);
		System.out.println("SHARE UserId: " + userId + " PostId: " + postId);
		Logger.debug(postId);

		ObjectNode jsonData = Json.newObject();
		try {
			jsonData.put("userId", userId);
			jsonData.put("postId", postId);
//			jsonData.put("text", postText);
//			jsonData.put("privacy", postStatus);
//			jsonData.put("PostTime", String.valueOf(originalPost.getPostTime()));

			JsonNode response =   APICall.postAPI(Constants.NEW_BACKEND + "posts/share", jsonData);
			//Application.flashMsg(response);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			Application.flashMsg(APICall
					.createResponse(ResponseType.CONVERSIONERROR));
		} catch (Exception e) {
			e.printStackTrace();
			Application.flashMsg(APICall.createResponse(ResponseType.UNKNOWN));
		}



		// return a text message

		// Call the delete() method
//		JsonNode response = ClimateService.delete(postId);

		// flash the response message
//		Application.flashMsg(response);

		return redirect("/homepage");
//		return ok(HomePage.render(PostSet.all(userId, currentPublicPager), postsetForm));
	}

	public static Result commentPost() throws Exception{
		DynamicForm df = DynamicForm.form().bindFromRequest();
		String postId = df.field("idHolder").value();
		String userId = session().get("userId");
		String text = df.field("text").value();
//		Integer tempId = Integer.parseInt(postId);
		System.out.println(userId + " Will comment: " + text);
		Logger.debug(postId);

		// return a text message

		// Call the delete() method

//		JsonNode response = ClimateService.delete(postId);

//		Application.flashMsg(response);
		ObjectNode jsonData = Json.newObject();
		try {
			jsonData.put("userId", userId);
			jsonData.put("postId", postId);
			jsonData.put("text", text);
//			jsonData.put("privacy", postStatus);
//			jsonData.put("PostTime", String.valueOf(originalPost.getPostTime()));

			JsonNode response = APICall.postAPI(Constants.NEW_BACKEND + "comments/add", jsonData);
			System.out.println("12: " + response.toString());
			//Application.flashMsg(response);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			Application.flashMsg(APICall
					.createResponse(ResponseType.CONVERSIONERROR));
		} catch (Exception e) {
			e.printStackTrace();
			Application.flashMsg(APICall.createResponse(ResponseType.UNKNOWN));
		}

		return redirect("/homepage");
	}

}
