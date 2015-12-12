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

	static int currentPrivatePager = 1;

	final static Form<PostSet> postsetForm = Form
			.form(PostSet.class);

	public static Result mainpage() throws Exception {
		currentPrivatePager = 1;
		System.out.println("Current private page: " + currentPrivatePager);
		String userId = session().get("userId");
		return ok(MainPage.render(PostSet.self(userId, currentPrivatePager),postsetForm));
	}

	public static Result previousPage() throws Exception {
		if (currentPrivatePager > 1) {
			currentPrivatePager--;
		}
		System.out.println("Current private page: " + currentPrivatePager);
		String userId = session().get("userId");
		return ok(MainPage.render(PostSet.self(userId, currentPrivatePager),postsetForm));
	}

	public static Result nextPage() throws Exception {
		currentPrivatePager++;
		System.out.println("Current private page: " + currentPrivatePager);
		String userId = session().get("userId");
		return ok(MainPage.render(PostSet.self(userId, currentPrivatePager),postsetForm));
	}

	public static Result searchPosts() throws Exception {
		String userId = session().get("userId");
		String keyword = "aaaaaaa";
		return ok(searchPosts.render(PostSet.search(userId, keyword),postsetForm));
	}

	public static Result editPost() throws Exception {

		ObjectNode jsonData = Json.newObject();
		String userId = session().get("userId");
		try {
			DynamicForm df = DynamicForm.form().bindFromRequest();
			String postId = df.field("pk").value();

			if (postId != null && !postId.isEmpty()) {
				jsonData.put("id", postId);
			}
			PostSet originalPost = PostSet.findPostById(postId, userId);

			if (originalPost == null) {
				Application.flashMsg(APICall.createResponse(ResponseType.UNKNOWN));
				return notFound("not found original post " + originalPost);
			}

			jsonData.put("id", Integer.parseInt(originalPost.getPostId()));
			jsonData.put("userId", originalPost.getUserId());
			String status = "";
			if (originalPost.getPostStatusL().contains("Private")) {
				status = "1";
			} else {
				status = "0";
			}
			jsonData.put("privacy", status);
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
			JsonNode response = ClimateService.edit(postId, jsonData);

			// flash the response message
			Application.flashMsg(response);

//			String userId = session().get("userId");
//			return ok(MainPage.render(PostSet.self(userId, currentPrivatePager),postsetForm));

		} catch (IllegalStateException e) {
			e.printStackTrace();
			Application.flashMsg(APICall
					.createResponse(ResponseType.CONVERSIONERROR));
		} catch (Exception e) {
			e.printStackTrace();
			Application.flashMsg(APICall.createResponse(ResponseType.UNKNOWN));
		}
		return ok("updated");
//		String userId = session().get("userId");
//		return ok(MainPage.render(PostSet.self(userId, currentPrivatePager),postsetForm));
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

		String userId = session().get("userId");
		return ok(MainPage.render(PostSet.self(userId, currentPrivatePager),postsetForm));
//		return redirect("/mainpage");
	}

	public static Result searchPostsClick() throws Exception {
		Form<PostSet> nu = postsetForm.bindFromRequest();
		String userId = session().get("userId");
		String keyword = nu.get().getKeyword();
		System.out.println("userId " + userId + " keyword: " + keyword);
		return ok(searchPosts.render(PostSet.search(userId, keyword),postsetForm));
//		return redirect("/searchPosts");
	}

	public static Result createNewPost() throws Exception{

		Form<PostSet> nu = postsetForm.bindFromRequest();
//		ObjectNode jsonData = Json.newObject();
//		String userName = null;
//

		System.out.println("text here: ");
		System.out.println(nu.get().getpostTextL());

		String userId = session().get("userId");
//		String postId = nu.get().getPostId();

		String postText = nu.get().getpostTextL();
		String postStatus = nu.get().getPostStatusL();

		double latitude = nu.get().getLatitude();
		double longitude = nu.get().getLongitude();
		String address = nu.get().getAddressL();

		System.out.println("Lat: " + latitude + " Long: " + longitude);
		System.out.println("Address: " + address);

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
			jsonData.put("address", address);
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
	}


}
