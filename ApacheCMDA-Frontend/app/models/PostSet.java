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

import java.lang.reflect.Array;
import java.net.URLEncoder;
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
	private String keyword;
	private String postComment;
	private String searchPost;
	private ArrayList<Comment> commentList;
	private String address;
	private double latitude;
	private double longitude;
	private String author;
	private int numberOfLike;

	public String getPostId() {
		return postId;
	}
	public String getPostTextS() {
		return postText.substring(1, postText.length() - 1);
	}
	public String getpostTextL() { return postText; }
	public String getPostStatusS() {
		return postStatus.substring(1, postStatus.length() - 1);
	}
	public String getPostStatusL(){
		return postStatus;
	}
	public String getUserId() {
		return userId;
	}
	public String getPostTimeS() {
		return postTime.substring(1, postTime.length() - 1);
	}
	public String getPostTimeL() {
		return postTime;
	}
	public String getKeyword() { return keyword; }
	public String getPostComment() {
		return postComment;
	}
	public String getSearchPost() { return searchPost; }
	public ArrayList<Comment> getCommentList() { return commentList; }
	public String getAddressS() { return address.substring(1, address.length() -1); }
	public String getAddressL() { return address; }
	public void setLatitude(double latitude) { this.latitude = latitude; }
	public void setLongitude(double longitude) { this.longitude = longitude;}
	public double getLatitude() {return latitude;}
	public double getLongitude() {return longitude;}
	public String getAuthorS() { return author.substring(1, author.length() - 1); }
	public String getAuthorL() { return author; }
	public int getNumberOfLike() { return numberOfLike; }

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
	public void setKeyword(String keyword) { this.keyword = keyword; }
	public void setPostComment(String postId, String userId, String text, String time) {
		Comment comment = new Comment();
		comment.setPostId(postId);
		comment.setUserId(userId);
		comment.setText(text);
		comment.setTime(time);
	}
	public void setSearchPost(String searchPost) { this.searchPost = searchPost; }
	public void setCommentList(ArrayList<Comment> commentList) { this.commentList = commentList; }
	public void setAddress(String address) { this.address = address; }
	public void setAuthor(String author) { this.author = author; }
	public void setNumberOfLike(int numberOfLike) {this.numberOfLike = numberOfLike; }
	
	private static final String GET_USERPOST = Constants.NEW_BACKEND + "posts/getPersonalPost/";
	private static final String GET_ALL_USERPOST = Constants.NEW_BACKEND + "posts/getPublicPost/";
	private static final String POSTSET_QUERY = Constants.NEW_BACKEND + "dataset/queryDataset";
	private static final String GET_TOP_POSTS = Constants.NEW_BACKEND + "posts/getTop10Posts/";
	private static final String SEARCH_POSTS = Constants.NEW_BACKEND + "posts/search/userId/";

	public static List<PostSet> all(String userId, int currentPage) throws JSONException {
		List<PostSet> postSets = new ArrayList<PostSet>();

		JsonNode postSet = APICall.callAPI(GET_ALL_USERPOST + userId + "/" + currentPage);
		String postString = postSet.toString();

		JsonParser parser = new JsonParser();

		if(postString.contains("error"))
			return postSets;

		JsonArray postSetNode = parser.parse(postString).getAsJsonArray();

		if (postSetNode == null || !postSetNode.isJsonArray()) {
			return postSets;
		}

		for (int i = 0; i < postSetNode.size(); i++) {
			PostSet postset = new PostSet();
			postset.setPostId(postSetNode.get(i).getAsJsonObject().get("id").toString());

			postset.setPostStatus("\"Public\"");
			postset.setPostText(postSetNode.get(i).getAsJsonObject().get("text").toString());
			postset.setAuthor(postSetNode.get(i).getAsJsonObject().get("userName").toString());
			postset.setUserId(postSetNode.get(i).getAsJsonObject().get("userId").toString());

			int userLikes = Integer.parseInt(postSetNode.get(i).getAsJsonObject().get("userLikes").toString());
			postset.setNumberOfLike(userLikes);
//			System.out.println("UserLikes: " + userLikes);

			postset.setAddress(postSetNode.get(i).getAsJsonObject().get("address").toString());
			String postTime = postSetNode.get(i).getAsJsonObject().get("time").toString();
			postset.setPostTime(postTime);

			ArrayList<Comment> commentList = new ArrayList<>();
			JsonArray commentArr = postSetNode.get(i).getAsJsonObject().get("userComments").getAsJsonArray();
			for (int j  = 0; j < commentArr.size(); j++) {
				Comment comment = new Comment();
				comment.setPostId(commentArr.get(j).getAsJsonObject().get("postId").toString());
				comment.setUserId(commentArr.get(j).getAsJsonObject().get("userId").toString());
				comment.setText(commentArr.get(j).getAsJsonObject().get("text").toString());
				comment.setTime(commentArr.get(j).getAsJsonObject().get("time").toString());
				comment.setAuthor(commentArr.get(j).getAsJsonObject().get("userName").toString());
				System.out.println("Public page: " + commentArr.get(j).getAsJsonObject().get("userName").toString());
				commentList.add(comment);
			}
			postset.setCommentList(commentList);
			postSets.add(postset);
		}
		return postSets;
	}

	public static List<PostSet> top(String userId) throws Exception {
		List<PostSet> postSets = new ArrayList<PostSet>();
//		URLEncoder.encode(postId, "UTF-8")
//		JsonNode postSet = APICall.callAPI(GET_TOP_POSTS + URLEncoder.encode(userId, "UTF-8"));
		JsonNode postSet = APICall.callAPI(GET_TOP_POSTS + userId);
		System.out.println("Top of userId: " + userId);

		String postString = postSet.toString();

		JsonParser parser = new JsonParser();

		if(postString.contains("error"))
			return postSets;

		JsonArray postSetNode = parser.parse(postString).getAsJsonArray();

		if (postSetNode == null || !postSetNode.isJsonArray()) {
			return postSets;
		}

		for (int i = 0; i < postSetNode.size(); i++) {
			PostSet postset = new PostSet();
			postset.setPostId(postSetNode.get(i).getAsJsonObject().get("id").toString());

			postset.setPostStatus("\"Public\"");
			postset.setPostText(postSetNode.get(i).getAsJsonObject().get("text").toString());
			postset.setUserId(postSetNode.get(i).getAsJsonObject().get("userId").toString());
			String postTime = postSetNode.get(i).getAsJsonObject().get("time").toString();
			postset.setPostTime(postTime);

			postSets.add(postset);
		}
		return postSets;
	}

	public static List<PostSet> self(String userId, int currentPage) throws JSONException {

		List<PostSet> postSets = new ArrayList<PostSet>();

		JsonNode postSet = APICall.callAPI(GET_USERPOST + userId + "/" + currentPage);
//		JsonNode postSet = APICall.callAPI(GET_USERPOST + userId);
		String postString = postSet.toString();

//		System.out.println("debug: " + postString);

		if(postString.contains("error"))
			return postSets;

		JsonParser parser = new JsonParser();
		JsonArray postSetNode = parser.parse(postString).getAsJsonArray();

		if (postSetNode == null || !postSetNode.isJsonArray()) {
			return postSets;
		}

		for (int i = 0; i < postSetNode.size(); i++) {
			PostSet postset = new PostSet();
			postset.setPostId(postSetNode.get(i).getAsJsonObject().get("id").toString());
			String privacy = postSetNode.get(i).getAsJsonObject().get("privacy").toString();
			if (privacy.contains("0"))
				privacy = "'Public'";
			else if (privacy.contains("1"))
				privacy = "'Private'";
			else
				privacy = "'unset'";
			postset.setPostStatus(privacy);
			postset.setPostText(postSetNode.get(i).getAsJsonObject().get("text").toString());
			postset.setAuthor(postSetNode.get(i).getAsJsonObject().get("userName").toString());
			postset.setUserId(postSetNode.get(i).getAsJsonObject().get("userId").toString());
			int userLikes = Integer.parseInt(postSetNode.get(i).getAsJsonObject().get("userLikes").toString());
			postset.setNumberOfLike(userLikes);
			postset.setAddress(postSetNode.get(i).getAsJsonObject().get("address").toString());


			ArrayList<Comment> commentList = new ArrayList<>();
			JsonArray commentArr = postSetNode.get(i).getAsJsonObject().get("userComments").getAsJsonArray();
			for (int j  = 0; j < commentArr.size(); j++) {
				Comment comment = new Comment();
				comment.setPostId(commentArr.get(j).getAsJsonObject().get("postId").toString());
				comment.setUserId(commentArr.get(j).getAsJsonObject().get("userId").toString());
				comment.setText(commentArr.get(j).getAsJsonObject().get("text").toString());
				comment.setTime(commentArr.get(j).getAsJsonObject().get("time").toString());
				comment.setAuthor(commentArr.get(j).getAsJsonObject().get("userName").toString());
				System.out.println("Private page: " + commentArr.get(j).getAsJsonObject().get("userName").toString());
				commentList.add(comment);
			}
			postset.setCommentList(commentList);

			String postTime = postSetNode.get(i).getAsJsonObject().get("time").toString();

			postset.setPostTime(postTime);

			postSets.add(postset);
		}
		return postSets;
	}

	public static List<PostSet> selfEdit(String userId) throws JSONException {

		List<PostSet> postSets = new ArrayList<PostSet>();

//		JsonNode postSet = APICall.callAPI(GET_USERPOST + userId + "/" + currentPage);
		JsonNode postSet = APICall.callAPI(GET_USERPOST + userId);
		String postString = postSet.toString();

//		System.out.println("debug: " + postString);

		if(postString.contains("error"))
			return postSets;

		JsonParser parser = new JsonParser();
		JsonArray postSetNode = parser.parse(postString).getAsJsonArray();

		if (postSetNode == null || !postSetNode.isJsonArray()) {
			return postSets;
		}

		for (int i = 0; i < postSetNode.size(); i++) {
			PostSet postset = new PostSet();
			postset.setPostId(postSetNode.get(i).getAsJsonObject().get("id").toString());
			String privacy = postSetNode.get(i).getAsJsonObject().get("privacy").toString();
			if (privacy.contains("0"))
				privacy = "'Public'";
			else if (privacy.contains("1"))
				privacy = "'Private'";
			else
				privacy = "'unset'";
			postset.setPostStatus(privacy);
			postset.setPostText(postSetNode.get(i).getAsJsonObject().get("text").toString());
			postset.setAuthor(postSetNode.get(i).getAsJsonObject().get("userName").toString());
			postset.setUserId(postSetNode.get(i).getAsJsonObject().get("userId").toString());
			int userLikes = Integer.parseInt(postSetNode.get(i).getAsJsonObject().get("userLikes").toString());
			postset.setNumberOfLike(userLikes);
			postset.setAddress(postSetNode.get(i).getAsJsonObject().get("address").toString());


			ArrayList<Comment> commentList = new ArrayList<>();
			JsonArray commentArr = postSetNode.get(i).getAsJsonObject().get("userComments").getAsJsonArray();
			for (int j  = 0; j < commentArr.size(); j++) {
				Comment comment = new Comment();
				comment.setPostId(commentArr.get(j).getAsJsonObject().get("postId").toString());
				comment.setUserId(commentArr.get(j).getAsJsonObject().get("userId").toString());
				comment.setText(commentArr.get(j).getAsJsonObject().get("text").toString());
				comment.setTime(commentArr.get(j).getAsJsonObject().get("time").toString());
				comment.setAuthor(commentArr.get(j).getAsJsonObject().get("userName").toString());
				System.out.println("Private page: " + commentArr.get(j).getAsJsonObject().get("userName").toString());
				commentList.add(comment);
			}
			postset.setCommentList(commentList);

			String postTime = postSetNode.get(i).getAsJsonObject().get("time").toString();

			postset.setPostTime(postTime);

			postSets.add(postset);
		}
		return postSets;
	}

	public static List<PostSet> search(String userId, String keyword) throws Exception {
		List<PostSet> postSets = new ArrayList<PostSet>();

		JsonNode postSet = APICall.callAPI(SEARCH_POSTS + userId + "/keyword/" + keyword);
		String postString = postSet.toString();

//		System.out.println("debug: " + postString);

		if(postString.contains("error"))
			return postSets;

		JsonParser parser = new JsonParser();
		JsonArray postSetNode = parser.parse(postString).getAsJsonArray();

		if (postSetNode == null || !postSetNode.isJsonArray()) {
			return postSets;
		}

		for (int i = 0; i < postSetNode.size(); i++) {
			PostSet postset = new PostSet();
			postset.setPostId(postSetNode.get(i).getAsJsonObject().get("id").toString());
			String privacy = postSetNode.get(i).getAsJsonObject().get("privacy").toString();
			if (privacy.contains("0"))
				privacy = "'Public'";
			else if (privacy.contains("1"))
				privacy = "'Private'";
			else
				privacy = "'unset'";
			postset.setPostStatus(privacy);
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


	public static List<PostSet> addPost(String userId, String postId, String postText, String postStatus) throws Exception {

		List<PostSet> res = new ArrayList<>();
		PostSet set = new PostSet();
		set.setUserId(userId);
		set.setPostId(postId);
		set.setPostText(postText);
		set.setPostStatus(postStatus);
//		set.setPostTime(postTime);

//		String postTime = json.findPath("postTime").asText();
		res.add(set);
		return res;
	}


	public static PostSet findPostById(String postId, String userId) throws Exception {
		List<PostSet> list = selfEdit(userId); //需要更改为另外的接口, get personal posts without page得到全部的personal posts.
		for (int i = 0; i < list.size(); i++) {
			if (postId.equals(list.get(i).getPostId())) {
				return list.get(i);
			}
		}
		return null;
	}

}
