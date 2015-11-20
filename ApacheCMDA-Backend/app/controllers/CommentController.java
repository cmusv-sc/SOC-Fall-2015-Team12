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
import models.UserCommentRepository;
import play.mvc.*;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import util.Common;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import models.UserComment;
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
@Named @Singleton public class CommentController extends Controller {

    private final UserCommentRepository userCommentRepository;

    // We are using constructor injection to receive a repository to support our
    // desire for immutability.
    @Inject public CommentController(final UserCommentRepository userCommentRepository) {
        this.userCommentRepository = userCommentRepository;
    }

    public Result addComment() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Comment not created, expecting Json data");
            return badRequest("Comment not created, expecting Json data");
        }
        // Parse JSON file
        Long postId = Long.parseLong(json.findPath("postId").asText());
        String userId = json.findPath("userId").asText();
        String text = json.findPath("text").asText();
        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat(Common.DATE_PATTERN);
        try {
            time = format.parse(json.findPath("time").asText());
        } catch (ParseException e) {
            System.out.println("No creation date specified, set to current time");
        }
        try {
            UserComment comment = new UserComment(postId, userId, text, time);
            userCommentRepository.save(comment);
            System.out.println("Comment saved: " + comment.getId());
            return created(new Gson().toJson(comment.getId()));
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Comment not saved: " + userId);
            return badRequest("Comment not saved: " + userId);
        }
    }
}
