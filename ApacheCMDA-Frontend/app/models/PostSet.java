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

package models;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import util.APICall;
import util.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostSet {

	private String postId;
	private String postText;
	private String postStatus;
	private String userId;
	private String postTime;
	
	public String getPostId() {
		return postId;
	}
	public String getPostText() {
		return postText;
	}
	public String getPostStatus() {

		return postStatus.substring(1, postStatus.length() - 1);
	}
	public String getUserId() {
		return userId;
	}
	public String getPostTime() {
		return postTime;
	}


	public void setPostId(String postId) {
		this.postId = postId;
	}
	public void setPostText(String postText) {
		this.postText = postText;
	}
	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	
	private static final String GET_USERPOST = Constants.NEW_BACKEND + "posts/getPersonalPost/";
	private static final String GET_ALL_USERPOST = Constants.NEW_BACKEND + "posts/getPublicPost/";
	private static final String POSTSET_QUERY = Constants.NEW_BACKEND + "dataset/queryDataset";

	public static List<PostSet> all() throws JSONException {
		List<PostSet> postSets = new ArrayList<PostSet>();

		JsonNode postSet = APICall.callAPI(GET_ALL_USERPOST + "3");
		String postString = postSet.toString();

		JsonParser parser = new JsonParser();
		JsonArray postSetNode = parser.parse(postString).getAsJsonArray();

		if (postSetNode == null || !postSetNode.isJsonArray()) {
			return postSets;
		}

		for (int i = 0; i < postSetNode.size(); i++) {
			PostSet postset = new PostSet();
			postset.setPostId(postSetNode.get(i).getAsJsonObject().get("id").toString());
			postset.setPostStatus(postSetNode.get(i).getAsJsonObject().get("privacy").toString());
			postset.setPostText(postSetNode.get(i).getAsJsonObject().get("text").toString());
			postset.setUserId(postSetNode.get(i).getAsJsonObject().get("userId").toString());

			String postTime = postSetNode.get(i).getAsJsonObject().get("time").toString();

			postset.setPostTime(postTime);

			postSets.add(postset);
		}
		return postSets;
	}

	public static List<PostSet> self(String userId) throws JSONException {

		List<PostSet> postSets = new ArrayList<PostSet>();

		JsonNode postSet = APICall.callAPI(GET_USERPOST + "3");
		String postString = postSet.toString();

		JsonParser parser = new JsonParser();
		JsonArray postSetNode = parser.parse(postString).getAsJsonArray();

		if (postSetNode == null || !postSetNode.isJsonArray()) {
			return postSets;
		}

		for (int i = 0; i < postSetNode.size(); i++) {
			PostSet postset = new PostSet();
			postset.setPostId(postSetNode.get(i).getAsJsonObject().get("id").toString());
			postset.setPostStatus(postSetNode.get(i).getAsJsonObject().get("privacy").toString());
			postset.setPostText(postSetNode.get(i).getAsJsonObject().get("text").toString());
			postset.setUserId(postSetNode.get(i).getAsJsonObject().get("userId").toString());

			String postTime = postSetNode.get(i).getAsJsonObject().get("time").toString();

			postset.setPostTime(postTime);

			postSets.add(postset);
		}
		return postSets;
	}

	public static List<PostSet> queryPostSet(String userId) {

		List<PostSet> postsets = new ArrayList<PostSet>();
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode queryJson = mapper.createObjectNode();
		queryJson.put("userId", userId);

		JsonNode postSetNode = APICall.postAPI(POSTSET_QUERY, queryJson);

		if (postSetNode == null || postSetNode.has("error")
				|| !postSetNode.isArray()) {
			return postsets;
		}

		for (int i = 0; i < postSetNode.size(); i++) {
			JsonNode json = postSetNode.path(i);
			PostSet newPostSet = deserializeJsonToPostSet(json);
			postsets.add(newPostSet);
		}
		return postsets;
	}

	private static PostSet deserializeJsonToPostSet(JsonNode json) {
		PostSet newPostSet = new PostSet();
		newPostSet.setUserId(json.get("userId").asText());
		newPostSet.setPostText(json.get("postText").asText());
		newPostSet.setPostId(json.get("postId").asText());
		newPostSet.setPostStatus(json.get("postStatus").asText());
		String postTime = json.findPath("postTime").asText();

		newPostSet.setPostTime(postTime);

		return newPostSet;
	}

	public static List<PostSet> example() throws Exception {
		List<PostSet> res = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			PostSet set = new PostSet();
			set.setPostStatus("public");
			set.setPostId("12" + i);
			set.setPostText(i + "we are the champion!");
			set.setUserId("a123456");
			String postTime = "NOV 12, 2015 12:00:01 PM";
			set.setPostTime(postTime);

			res.add(set);
		}
		return res;
	}

	public static PostSet findPostById(String postId) throws Exception {
		List<PostSet> list = self("3");
		for (int i = 0; i < list.size(); i++) {
			if (postId.equals(list.get(i).getPostId())) {
				return list.get(i);
			}
		}
		return null;
	}

}
