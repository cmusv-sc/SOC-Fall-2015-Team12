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
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import models.*;
import util.Common;
import models.UserLike;
import play.mvc.*;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

/**
 * The main set of posts.
 */
@Named @Singleton public class PostController extends Controller {

    private final PostRepository postRepository;
    private final UserCommentRepository userCommentRepository;
    private final UserLikeRepository userLikeRepository;

    // We are using constructor injection to receive a repository to support our
    // desire for immutability.
    @Inject public PostController(final PostRepository postRepository,
        UserCommentRepository userCommentRepository, UserLikeRepository userLikeRepository) {
        this.postRepository = postRepository;
        this.userCommentRepository = userCommentRepository;
        this.userLikeRepository = userLikeRepository;
    }

    public Result addPost() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Post not created, expecting Json data");
            return badRequest("Post not created, expecting Json data");
        }
        // Parse JSON file

        String userId = json.findPath("userId").asText();
        int privacy = Integer.parseInt(json.findPath("privacy").asText());
        String text = json.findPath("text").asText();
        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat(Common.DATE_PATTERN);
        try {
            time = format.parse(json.findPath("time").asText());
        } catch (ParseException e) {
            System.out.println("No creation date specified, set to current time");
        }
        try {
            Post post = new Post(userId, privacy, text, time);
            postRepository.save(post);
            System.out.println("Post saved: " + post.getId());
            return created(new Gson().toJson(post.getId()));
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("post not saved: " + userId);
            return badRequest("post not saved: " + userId);
        }
    }

    //public: privacy = 0
	public Result getPublicPost(String userId) {

        if(userId == null || userId.length() == 0){
            System.out.println("User id is null or empty!");
            return badRequest("User id is null or empty!");
        }

        List<Post> posts = postRepository.findPostWithUserId(userId);
		if (posts == null || posts.size() == 0) {
			System.out.println("Post not exist!");
			return badRequest("Post not exist!");
		}

//        JsonObject result = new JsonObject();
        JsonArray postArray = new JsonArray();
        JsonObject postDetails = new JsonObject();
        String userIdP = "";
        int privacyP = 0;
        String textP = "";
        Date timeP = null;
        Long postId = 0l;

        for(Post p : posts){
            postId = p.getId();
            userIdP = p.getUserId();
            privacyP = p.getPrivacy();
            textP = p.getText();
            timeP = p.getTime();

            if(privacyP == 1) continue;
            postDetails.addProperty("id", postId);
            postDetails.addProperty("userId", userIdP);
            postDetails.addProperty("privacy", privacyP + "");
            postDetails.addProperty("text", textP);
            postDetails.addProperty("time", timeP + "");

            JsonArray commentArray = new JsonArray();
            System.out.println(postId);
            List<UserComment> userComments = userCommentRepository.findCommentWithPostId(postId);
            JsonObject comDetails = new JsonObject();
            Long postIdC = 0l;
            String userIdC = "";
            String textC = "";
            Date timeC = null;
            if(userComments!=null) {
                System.out.println(userComments.size());
                for (int i=0;i<userComments.size();i++) {
                    System.out.println("haha "+userComments.get(i));
                    UserComment c=userComments.get(i);
                    postIdC = c.getPostId();
                    userIdC = c.getUserId();
                    textC = c.getText();
                    timeC = c.getTime();
                    comDetails.addProperty("postId", postIdC);
                    comDetails.addProperty("userId", userIdC);
                    comDetails.addProperty("text", textC);
                    comDetails.addProperty("time", timeC.toString());

                    commentArray.add(comDetails);
                    comDetails = new JsonObject();
                }
            }
            postDetails.add("userComments", commentArray);

            JsonArray likeArray = new JsonArray();
            List<UserLike> likes = userLikeRepository.findLikeWithPostId(postId);
            JsonObject likeDetails = new JsonObject();
            Long postIdL = 0l;
            String userIdL = "";
            Date timeL = null;
            for(UserLike l : likes) {
                postIdL = l.getPostId();
                userIdL = l.getUserId();
                timeL = l.getTime();
                likeDetails.addProperty("postId", postIdL);
                likeDetails.addProperty("userId", userIdL);
                likeDetails.addProperty("time", timeL.toString());

                likeArray.add(likeDetails);
                likeDetails = new JsonObject();
            }

            postDetails.add("userLikes", likeArray);
            postArray.add(postDetails);
            postDetails = new JsonObject();
        }

//        result.add("posts", postArray);
//		return ok(result.toString());
        return ok(postArray.toString());
	}

    //personal: privacy = 0/1
	public Result getPersonalPost(String userId) {
        if(userId == null || userId.length() == 0){
            System.out.println("User id is null or empty!");
            return badRequest("User id is null or empty!");
        }

        List<Post> posts = postRepository.findPostWithUserId(userId);
        if (posts == null || posts.size() ==0) {
            System.out.println("Post not exist!");
            return badRequest("Post not exist!");
        }

//        JsonObject result = new JsonObject();
        JsonArray postArray = new JsonArray();
        JsonObject postDetails = new JsonObject();
        String userIdP = "";
        int privacyP = 0;
        String textP = "";
        Date timeP = null;
        Long postId = 0l;

        for(Post p : posts){
            postId = p.getId();
            userIdP = p.getUserId();
            privacyP = p.getPrivacy();
            textP = p.getText();
            timeP = p.getTime();

            postDetails.addProperty("id", postId);
            postDetails.addProperty("userId", userIdP);
            postDetails.addProperty("privacy", privacyP + "");
            postDetails.addProperty("text", textP);
            postDetails.addProperty("time", timeP + "");

            JsonArray commentArray = new JsonArray();
            List<UserComment> userComments = userCommentRepository.findCommentWithPostId(postId);
            JsonObject comDetails = new JsonObject();
            Long postIdC = 0l;
            String userIdC = "";
            String textC = "";
            Date timeC = null;
            for(UserComment c : userComments) {
                postIdC = c.getPostId();
                userIdC = c.getUserId();
                textC = c.getText();
                timeC = c.getTime();
                comDetails.addProperty("postId", postIdC);
                comDetails.addProperty("userId", userIdC);
                comDetails.addProperty("text", textC);
                comDetails.addProperty("time", timeC.toString());

                commentArray.add(comDetails);
                comDetails = new JsonObject();
            }

            postDetails.add("userComments", commentArray);

            JsonArray likeArray = new JsonArray();
            List<UserLike> likes = userLikeRepository.findLikeWithPostId(postId);
            JsonObject likeDetails = new JsonObject();
            Long postIdL = 0l;
            String userIdL = "";
            Date timeL = null;
            for(UserLike l : likes) {
                postIdL = l.getPostId();
                userIdL = l.getUserId();
                timeL = l.getTime();
                likeDetails.addProperty("postId", postIdL);
                likeDetails.addProperty("userId", userIdL);
                likeDetails.addProperty("time", timeL.toString());

                likeArray.add(likeDetails);
                likeDetails = new JsonObject();
            }

            postDetails.add("userLikes", likeArray);
            postArray.add(postDetails);
            postDetails = new JsonObject();
        }

//        result.add("posts", postArray);
//        return ok(result.toString());
        return ok(postArray.toString());
	}

    public Result getPostById(long id, String format) {

        Post post = postRepository.findOne(id);

        if (post == null) {
            System.out.println("post not found with id: " + id);
            return notFound("post not found with id: " + id);
        }

        String result = new String();
        if (format.equals("json")) {
            result = new Gson().toJson(post);
        }
        return ok(result);
    }


    public Result updatePostById(long id) {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("post not saved, expecting Json data");
            return badRequest("post not saved, expecting Json data");
        }
        // Parse JSON file
        String userId = json.findPath("userId").asText();
        int privacy = Integer.parseInt(json.findPath("privacy").asText());
        String text = json.findPath("text").asText();
        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat(Common.DATE_PATTERN);
        try {
            time = format.parse(json.findPath("time").asText());
        } catch (ParseException e) {
            System.out.println("No creation date specified, set to current time");
        }

        Post post = postRepository.findOne(id);

        post.setText(text);
        post.setPrivacy(privacy);
        post.setTime(time);

        try {
            postRepository.save(post);
            System.out.println("Post updated: " + post.getId());
            return created("Post updated: " + post.getId());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Post not updated: " + id);
            return badRequest("Post not updated: " + id);
        }


    }

    public Result deletePostById(long id) {

        Post deletePost = postRepository.findOne(id);
        if (deletePost == null) {
            System.out.println("Post not found with id: " + id);
            return notFound("Post not found with id: " + id);
        }

        //delete coments
        List<UserComment> deleteUserComments = userCommentRepository.findAllByPostId(deletePost.getId());
        if (deleteUserComments != null) {
            for (UserComment deleteComent : deleteUserComments) {
                userCommentRepository.delete(deleteComent);
            }
        }

        /*
        //delete likes
        List<UserLike> deleteLikes = likeRepository.findAllByPostId(deletePost.getId());
        if(deleteLikes!=null) {
            for (UserLike deleteLike : deleteLikes) {
                likeRepository.delete(deleteLike);
            }
        }*/

        //delete post
        postRepository.delete(deletePost);
        System.out.println("Post is deleted: " + id);

        return ok("Post is deleted: " + id);
    }

}
