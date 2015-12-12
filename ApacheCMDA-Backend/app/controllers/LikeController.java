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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import models.*;
import play.mvc.*;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import util.Common;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import models.UserLike;
import models.Post;
import java.util.List;
import play.mvc.*;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;

/**
 * The main set of posts.
 */
@Named @Singleton public class LikeController extends Controller {

    private final UserLikeRepository userLikeRepository;
    private final PostRepository postRepository;

    // We are using constructor injection to receive a repository to support our
    // desire for immutability.
    @Inject public LikeController(final UserLikeRepository userLikeRepository, final PostRepository postRepository) {
        this.userLikeRepository = userLikeRepository;
        this.postRepository = postRepository;
    }

    public Result addLike() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Like not created, expecting Json data");
            return badRequest("Like not created, expecting Json data");
        }
        // Parse JSON file
        Long postId = Long.parseLong(json.findPath("postId").asText());
        String userId = json.findPath("userId").asText();
        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat(Common.DATE_PATTERN);
        try {
            time = format.parse(json.findPath("time").asText());
        } catch (ParseException e) {
            System.out.println("No creation date specified, set to current time");
        }

        try {
            UserLike like = new UserLike(postId, userId, time);
            userLikeRepository.save(like);
            System.out.println("Like saved: " + like.getId());
            return created(new Gson().toJson(like.getId()));
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println(postId + "\n" + userId + "\n" + time);
            System.out.println("Like not saved:a " + userId);
            return badRequest("Like not saved:s " + userId);
        }
    }

    public Result getNumOfLikes(Long postId) {
        if(postId == null){
            System.out.println("User id is null!");
            return badRequest("User id is null!");
        }

        Post posts = postRepository.findById(postId);
        if (posts == null) {
            System.out.println("Post not exist!");
            return badRequest("Post not exist!");
        }

        List<UserLike> likes = userLikeRepository.findLikeWithPostId(postId);
        return created(new Gson().toJson((likes.size())));
    }



}
