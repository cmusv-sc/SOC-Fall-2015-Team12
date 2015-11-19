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
import models.UserLikeRepository;
import play.mvc.*;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import util.Common;
import util.Constants;


import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import models.Post;
import models.PostRepository;
import models.UserComment;
import models.UserCommentRepository;
import models.UserLike;
import models.UserLikeRepository;
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
@Named @Singleton public class LikeController extends Controller {

    private final UserLikeRepository userLikeRepository;

    // We are using constructor injection to receive a repository to support our
    // desire for immutability.
    @Inject public LikeController(final UserLikeRepository userLikeRepository) {
        this.userLikeRepository = userLikeRepository;
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


}
