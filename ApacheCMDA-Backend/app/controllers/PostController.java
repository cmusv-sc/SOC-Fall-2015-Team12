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
import java.util.*;
import java.lang.String;
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
    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    // We are using constructor injection to receive a repository to support our
    // desire for immutability.
    @Inject
    public PostController(final PostRepository postRepository,
                          UserCommentRepository userCommentRepository, UserLikeRepository userLikeRepository, UserRepository userRepository, FollowRepository followRepository) {
        this.postRepository = postRepository;
        this.userCommentRepository = userCommentRepository;
        this.userLikeRepository = userLikeRepository;
        this.userRepository = userRepository;
        this.followRepository = followRepository;
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
        String address = json.findPath("address").asText();
        try {
            time = format.parse(json.findPath("time").asText());
        } catch (ParseException e) {
            System.out.println("No creation date specified, set to current time");
        }
        try {
            Post post = new Post(userId, privacy, text, time, address);
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
    public Result getPublicPost(String userId, String page) {

        if (userId == null || userId.length() == 0) {
            System.out.println("User id is null or empty!");
            return badRequest("User id is null or empty!");
        }

        User user = userRepository.findOne(Long.parseLong(userId));
        if (user == null) {
            System.out.println("User not found with id: " + userId);
            return notFound("User not found");
        }

        List<Post> posts = postRepository.findPostWithUserId(userId);
        if (posts == null || posts.size() == 0) {
            System.out.println("Post not exist!");
            return badRequest("Post not exist!");
        }

        JsonArray postArray = new JsonArray();
        JsonObject postDetails = new JsonObject();
        String userIdP = "";
        int privacyP = 0;
        String textP = "";
        Date timeP = null;
        Long postId = 0l;
        String addressP = "";
        String userNameP = "";


        for (Post p : posts) {
            postId = p.getId();
            userIdP = p.getUserId();
            privacyP = p.getPrivacy();
            textP = p.getText();
            timeP = p.getTime();
            addressP = p.getAddress();
            userNameP = userRepository.findOne(Long.parseLong(userIdP)).getUserName();


            if (privacyP == 1) continue;
            postDetails.addProperty("id", postId);
            postDetails.addProperty("userId", userIdP);
            postDetails.addProperty("privacy", privacyP + "");
            postDetails.addProperty("text", textP);
            postDetails.addProperty("time", timeP + "");
            postDetails.addProperty("address", addressP);
            postDetails.addProperty("userName", userNameP);

            JsonArray commentArray = new JsonArray();
            List<UserComment> userComments = userCommentRepository.findCommentWithPostId(postId);
            JsonObject comDetails = new JsonObject();
            String userIdC = "";
            String textC = "";
            Date timeC = null;
            String userNameC = "";

            for (UserComment c : userComments) {
                userIdC = c.getUserId();
                textC = c.getText();
                timeC = c.getTime();
                userNameC = userRepository.findOne(Long.parseLong(userIdC)).getUserName();

                comDetails.addProperty("postId", postId);
                comDetails.addProperty("userId", userIdC);
                comDetails.addProperty("text", textC);
                comDetails.addProperty("time", timeC.toString());
                comDetails.addProperty("userName", userNameC);

                commentArray.add(comDetails);
                comDetails = new JsonObject();
            }

            postDetails.add("userComments", commentArray);

            List<UserLike> likes = userLikeRepository.findLikeWithPostId(postId);
            int numOfLikes = likes.size();

            postDetails.addProperty("userLikes", numOfLikes);
            postArray.add(postDetails);
            postDetails = new JsonObject();
        }

        Set<Follow> followees = followRepository.findAllByFollower(Long.parseLong(userId));
        if (followees == null){

        }
        else{
            for (Follow f : followees){
                List<Post> postsOfFollowee = postRepository.findPostWithUserId(f.getFollowee()+"");
                if (postsOfFollowee == null || posts.size() == 0) {

                }
                else {
                    for (Post p1 : postsOfFollowee){
                        postId = p1.getId();
                        userIdP = p1.getUserId();
                        privacyP = p1.getPrivacy();
                        textP = p1.getText();
                        timeP = p1.getTime();
                        addressP = p1.getAddress();
                        userNameP = userRepository.findOne(Long.parseLong(userIdP)).getUserName();

                        if (privacyP == 1) continue;
                        postDetails.addProperty("id", postId);
                        postDetails.addProperty("userId", userIdP);
                        postDetails.addProperty("privacy", privacyP + "");
                        postDetails.addProperty("text", textP);
                        postDetails.addProperty("time", timeP + "");
                        postDetails.addProperty("address", addressP + "");
                        postDetails.addProperty("userName", userNameP);

                        JsonArray commentArray = new JsonArray();
                        List<UserComment> userComments = userCommentRepository.findCommentWithPostId(postId);
                        JsonObject comDetails = new JsonObject();
                        String userIdC = "";
                        String textC = "";
                        Date timeC = null;
                        String userNameC = "";

                        for (UserComment c : userComments) {
                            userIdC = c.getUserId();
                            textC = c.getText();
                            timeC = c.getTime();
                            userNameC = userRepository.findOne(Long.parseLong(userIdC)).getUserName();

                            comDetails.addProperty("postId", postId);
                            comDetails.addProperty("userId", userIdC);
                            comDetails.addProperty("text", textC);
                            comDetails.addProperty("time", timeC.toString());
                            comDetails.addProperty("userName", userNameC);


                            commentArray.add(comDetails);
                            comDetails = new JsonObject();
                        }

                        postDetails.add("userComments", commentArray);
                        List<UserLike> likes = userLikeRepository.findLikeWithPostId(postId);
                        int numOfLikes = likes.size();

                        postDetails.addProperty("userLikes", numOfLikes);
                        postArray.add(postDetails);
                        postDetails = new JsonObject();
                    }
                }
            }
        }

        PriorityQueue<JsonObject> q = new PriorityQueue<JsonObject>(100, new timeComparator());
        for(int m = 0; m < postArray.size(); m++){
            q.add(postArray.get(m).getAsJsonObject());
        }

        int showPage = Integer.parseInt(page);
        int availablePage = (q.size()%5 == 0)?(q.size()/5):(q.size()/5 + 1);
        JsonArray returnArray = new JsonArray();
        JsonObject a;
        if(showPage <= availablePage){
            showPage = showPage - 1;
            int count = 1;
            int innerCount = 0;
            while((a = q.poll()) != null){
                if(count > showPage * 5) {
                    innerCount++;
                    returnArray.add(a);
                    if(innerCount == 5) break;
                }
                count++;
            }
            return ok(returnArray.toString());
        }
        else {
            return ok(returnArray.toString());
        }
    }

    //personal: privacy = 0/1
    public Result getPersonalPost(String userId, String page) {
        if (userId == null || userId.length() == 0) {
            System.out.println("User id is null or empty!");
            return badRequest("User id is null or empty!");
        }

        List<Post> posts = postRepository.findPostWithUserId(userId);
        if (posts == null || posts.size() == 0) {
            System.out.println("Post not exist!");
            return badRequest("Post not exist!");
        }

        JsonArray postArray = new JsonArray();
        JsonObject postDetails = new JsonObject();
        String userIdP = "";
        int privacyP = 0;
        String textP = "";
        Date timeP = null;
        Long postId = 0l;
        String addressP = "";
        String userNameP = "";

        for (Post p : posts) {
            postId = p.getId();
            userIdP = p.getUserId();
            privacyP = p.getPrivacy();
            textP = p.getText();
            timeP = p.getTime();
            addressP = p.getAddress();
            userNameP = userRepository.findOne(Long.parseLong(userIdP)).getUserName();

            postDetails.addProperty("id", postId);
            postDetails.addProperty("userId", userIdP);
            postDetails.addProperty("privacy", privacyP + "");
            postDetails.addProperty("text", textP);
            postDetails.addProperty("time", timeP + "");
            postDetails.addProperty("address", addressP + "");
            postDetails.addProperty("userName", userNameP);

            JsonArray commentArray = new JsonArray();
            List<UserComment> userComments = userCommentRepository.findCommentWithPostId(postId);
            JsonObject comDetails = new JsonObject();
            Long postIdC = 0l;
            String userIdC = "";
            String textC = "";
            Date timeC = null;
            String userNameC = "";

            for (UserComment c : userComments) {
                postIdC = c.getPostId();
                userIdC = c.getUserId();
                textC = c.getText();
                timeC = c.getTime();
                userNameC = userRepository.findOne(Long.parseLong(userIdC)).getUserName();

                comDetails.addProperty("postId", postIdC);
                comDetails.addProperty("userId", userIdC);
                comDetails.addProperty("text", textC);
                comDetails.addProperty("time", timeC.toString());
                comDetails.addProperty("userName", userNameC);

                commentArray.add(comDetails);
                comDetails = new JsonObject();
            }

            postDetails.add("userComments", commentArray);

            List<UserLike> likes = userLikeRepository.findLikeWithPostId(postId);
            int numOfLikes = likes.size();

            postDetails.addProperty("userLikes", numOfLikes);
            postArray.add(postDetails);
            postDetails = new JsonObject();
        }

        PriorityQueue<JsonObject> q = new PriorityQueue<JsonObject>(100, new timeComparator());
        for(int m = 0; m < postArray.size(); m++){
            q.add(postArray.get(m).getAsJsonObject());
        }

        int showPage = Integer.parseInt(page);
        int availablePage = (q.size()%5 == 0)?(q.size()/5):(q.size()/5 + 1);
        JsonArray returnArray = new JsonArray();
        JsonObject a;
        if(showPage <= availablePage){
            showPage = showPage - 1;
            int count = 1;
            int innerCount = 0;
            while((a = q.poll()) != null){
                if(count > showPage * 5) {
                    innerCount++;
                    returnArray.add(a);
                    if(innerCount == 5) break;
                }
                count++;
            }
            return ok(returnArray.toString());
        }
        else {
            return ok(returnArray.toString());
        }
    }

    public Result getPersonalPostWithoutPage(String userId) {
        if (userId == null || userId.length() == 0) {
            System.out.println("User id is null or empty!");
            return badRequest("User id is null or empty!");
        }

        List<Post> posts = postRepository.findPostWithUserId(userId);
        if (posts == null || posts.size() == 0) {
            System.out.println("Post not exist!");
            return badRequest("Post not exist!");
        }

        JsonArray postArray = new JsonArray();
        JsonObject postDetails = new JsonObject();
        String userIdP = "";
        int privacyP = 0;
        String textP = "";
        Date timeP = null;
        Long postId = 0l;
        String addressP = "";
        String userNameP = "";

        for (Post p : posts) {
            postId = p.getId();
            userIdP = p.getUserId();
            privacyP = p.getPrivacy();
            textP = p.getText();
            timeP = p.getTime();
            addressP = p.getAddress();
            userNameP = userRepository.findOne(Long.parseLong(userIdP)).getUserName();

            postDetails.addProperty("id", postId);
            postDetails.addProperty("userId", userIdP);
            postDetails.addProperty("privacy", privacyP + "");
            postDetails.addProperty("text", textP);
            postDetails.addProperty("time", timeP + "");
            postDetails.addProperty("address", addressP + "");
            postDetails.addProperty("userName", userNameP);

            JsonArray commentArray = new JsonArray();
            List<UserComment> userComments = userCommentRepository.findCommentWithPostId(postId);
            JsonObject comDetails = new JsonObject();
            Long postIdC = 0l;
            String userIdC = "";
            String textC = "";
            Date timeC = null;
            String userNameC = "";

            for (UserComment c : userComments) {
                postIdC = c.getPostId();
                userIdC = c.getUserId();
                textC = c.getText();
                timeC = c.getTime();
                userNameC = userRepository.findOne(Long.parseLong(userIdC)).getUserName();

                comDetails.addProperty("postId", postIdC);
                comDetails.addProperty("userId", userIdC);
                comDetails.addProperty("text", textC);
                comDetails.addProperty("time", timeC.toString());
                comDetails.addProperty("userName", userNameC);

                commentArray.add(comDetails);
                comDetails = new JsonObject();
            }

            postDetails.add("userComments", commentArray);

            List<UserLike> likes = userLikeRepository.findLikeWithPostId(postId);
            int numOfLikes = likes.size();

            postDetails.addProperty("userLikes", numOfLikes);
            postArray.add(postDetails);
            postDetails = new JsonObject();
        }

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
        System.out.println("update receive=" + json);
        if (json == null) {
            System.out.println("post not saved, expecting Json data");
            return badRequest("post not saved, expecting Json data");
        }
        // Parse JSON file
        String userId = json.findPath("userId").asText();
        int privacy = Integer.parseInt(json.findPath("privacy").asText());
        String text = json.findPath("text").asText();

//        System.out.println("text=" + text);

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
            return badRequest("Post not found with id: " + id);
            //return notFound("Post not found with id: " + id);
        }

        //delete coments
        List<UserComment> deleteUserComments = userCommentRepository.findAllByPostId(deletePost.getId());
        if (deleteUserComments != null) {
            for (UserComment deleteComent : deleteUserComments) {
                userCommentRepository.delete(deleteComent);
            }
        }


        //delete likes
        List<UserLike> deleteLikes = userLikeRepository.findLikeWithPostId(deletePost.getId());
        if(deleteLikes!=null) {
            for (UserLike deleteLike : deleteLikes) {
                userLikeRepository.delete(deleteLike);
            }
        }

        //delete post
        postRepository.delete(deletePost);
        System.out.println("Post is deleted: " + id);
        JsonArray result = new JsonArray();
        JsonObject a = new JsonObject();
        a.addProperty("response", "Post is deleted: " + id);
        result.add(a);
        return created(result.toString());
    }

    public Result getTop10Posts(Long userId) {

        User user = userRepository.findOne(userId);

        if (user == null) {
            System.out.println("User not found with id: " + userId);
            return notFound("User not found");
        }

        List<Post> posts = postRepository.findPostWithLongUserId(userId);
        if (posts == null || posts.size() == 0) {
            System.out.println("Post not exist!");
            return badRequest("Post not exist!");
        }

        JsonArray postArray = new JsonArray();
        JsonObject postDetails = new JsonObject();
        String userIdP = "";
        int privacyP = 0;
        String textP = "";
        Date timeP = null;
        Long postId = 0l;
        String addressP = "";
        String userNameP = "";

        ArrayList<rankHelper> allPosts = new ArrayList<rankHelper>();
        for (Post p : posts){
            rankHelper rh = new rankHelper();
            rh.setPostId(p.getId());
            List<UserComment> userComments = userCommentRepository.findCommentWithPostId(p.getId());
            if(userComments != null) {
                rh.setNumOfComment(userComments.size());
            }
            else {
                rh.setNumOfComment(0);
            }
            List<UserLike> likes = userLikeRepository.findLikeWithPostId(p.getId());
            if(likes != null) {
                rh.setNumOfLike(likes.size());
            }
            else {
                rh.setNumOfLike(0);
            }
            rh.setSum(rh.getNumOfComment() + rh.getNumOfLike());
            allPosts.add(rh);
        }

        rankComparator rc = new rankComparator();
        Collections.sort(allPosts, rc);
        int count = 0;
        for(rankHelper e : allPosts){
            Long post_id = e.getPostId();
            Post p = postRepository.findById(post_id);
            userIdP = p.getUserId();
            privacyP = p.getPrivacy();
            textP = p.getText();
            timeP = p.getTime();
            addressP = p.getAddress();
            userNameP = userRepository.findOne(Long.parseLong(userIdP)).getUserName();

            postDetails.addProperty("id", post_id);
            postDetails.addProperty("userId", userIdP);
            postDetails.addProperty("privacy", privacyP + "");
            postDetails.addProperty("text", textP);
            postDetails.addProperty("time", timeP + "");
            postDetails.addProperty("address", addressP + "");
            postDetails.addProperty("userName", userNameP);

            JsonArray commentArray = new JsonArray();
            List<UserComment> userComments = userCommentRepository.findCommentWithPostId(post_id);
            JsonObject comDetails = new JsonObject();
            String userIdC = "";
            String textC = "";
            Date timeC = null;
            String userNameC = "";

            for (UserComment c : userComments) {
                userIdC = c.getUserId();
                textC = c.getText();
                timeC = c.getTime();
                userNameC = userRepository.findOne(Long.parseLong(userIdC)).getUserName();
                comDetails.addProperty("postId", post_id);
                comDetails.addProperty("userId", userIdC);
                comDetails.addProperty("text", textC);
                comDetails.addProperty("time", timeC.toString());
                comDetails.addProperty("userName", userNameC);

                commentArray.add(comDetails);
                comDetails = new JsonObject();
            }

            postDetails.add("userComments", commentArray);

            List<UserLike> likes = userLikeRepository.findLikeWithPostId(post_id);
            int numOfLikes = likes.size();

            postDetails.addProperty("userLikes", numOfLikes);
            postArray.add(postDetails);
            postDetails = new JsonObject();
            count++;
            if(count == 10) break;
        }

        return ok(postArray.toString());
    }

    public Result searchPost(String userId, String keyword, String format) {

        if(userId == null || userId.length() == 0){
            System.out.println("User id is null or empty!");
            return badRequest("User id is null or empty!");
        }

        List<Post> posts = postRepository.searchPost(userId, keyword);
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
        String userNameP = "";

        for(Post p : posts){
            postId = p.getId();
            userIdP = p.getUserId();
            privacyP = p.getPrivacy();
            textP = p.getText();
            timeP = p.getTime();
            userNameP = userRepository.findOne(Long.parseLong(userIdP)).getUserName();

            postDetails.addProperty("id", postId);
            postDetails.addProperty("userId", userIdP);
            postDetails.addProperty("privacy", privacyP + "");
            postDetails.addProperty("text", textP);
            postDetails.addProperty("time", timeP + "");
            postDetails.addProperty("userName", userNameP);

            JsonArray commentArray = new JsonArray();
            List<UserComment> userComments = userCommentRepository.findCommentWithPostId(postId);
            JsonObject comDetails = new JsonObject();
            Long postIdC = 0l;
            String userIdC = "";
            String textC = "";
            Date timeC = null;
            String userNameC = "";

            for(UserComment c : userComments) {
                postIdC = c.getPostId();
                userIdC = c.getUserId();
                textC = c.getText();
                timeC = c.getTime();
                userNameC = userRepository.findOne(Long.parseLong(userIdC)).getUserName();

                comDetails.addProperty("postId", postIdC);
                comDetails.addProperty("userId", userIdC);
                comDetails.addProperty("text", textC);
                comDetails.addProperty("time", timeC.toString());
                comDetails.addProperty("userName", userNameC);

                commentArray.add(comDetails);
                comDetails = new JsonObject();
            }

            postDetails.add("userComments", commentArray);

            List<UserLike> likes = userLikeRepository.findLikeWithPostId(postId);
            int numOfLikes = likes.size();

            postDetails.addProperty("userLikes", numOfLikes);
            postArray.add(postDetails);
            postDetails = new JsonObject();
        }
        return ok(postArray.toString());
    }

    public Result sharePost() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Post not created, expecting Json data");
            return badRequest("Post not created, expecting Json data");
        }
        // Parse JSON file

        String userId = json.findPath("userId").asText();
        String postId = json.findPath("postId").asText();

        Post sharePost = postRepository.findOne(Long.parseLong(postId));

        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat(Common.DATE_PATTERN);
//        String address = json.findPath("address").asText();
        try {
            time = format.parse(json.findPath("time").asText());
        } catch (ParseException e) {
            System.out.println("No creation date specified, set to current time");
        }
        try {
            String newText = sharePost.getText();
            String address = sharePost.getAddress();
            if(!newText.startsWith("[Shared] "))
                newText="[Shared] "+newText;
            Post post = new Post(userId, 0, newText, time, address);
            postRepository.save(post);
            System.out.println("Share post saved: " + post.getId());
            return created(new Gson().toJson(post.getId()));
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Share post not saved: " + userId);
            return badRequest("Share post not saved: " + userId);
        }
    }





}

class rankHelper{
    long postId;
    int numOfLike;
    int numOfComment;
    int sum;

    public void setPostId(long postId){
        this.postId = postId;
    }

    public long getPostId(){
        return postId;
    }

    public void setNumOfLike(int numOfLike){
        this.numOfLike = numOfLike;
    }

    public int getNumOfLike(){
        return numOfLike;
    }

    public void setNumOfComment(int numOfComment){
        this.numOfComment = numOfComment;
    }

    public int getNumOfComment(){
        return numOfComment;
    }

    public void setSum(int sum){
        this.sum = sum;
    }

    public int getSum(){
        return sum;
    }
}

class rankComparator implements Comparator<rankHelper>{
    @Override
    public int compare(rankHelper rh1, rankHelper rh2){
        int sum1 = rh1.getSum();
        int sum2 = rh2.getSum();
        return (sum2 - sum1);
    }
}

class timeComparator implements Comparator<JsonObject>{
    @Override
    public int compare(JsonObject o1, JsonObject o2){
        String s1 = o1.get("time").getAsString();
        String s2 = o2.get("time").getAsString();
        return s2.compareTo(s1);
    }
}





