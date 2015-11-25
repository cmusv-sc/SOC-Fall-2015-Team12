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
import models.FollowRepository;
import play.mvc.*;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import util.Common;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import models.Follow;
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
@Named @Singleton public class FollowController extends Controller {

    private final FollowRepository followRepository;

    // We are using constructor injection to receive a repository to support our
    // desire for immutability.
    @Inject public FollowController(final FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    public Result addFollow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Follow not created, expecting Json data");
            return badRequest("Follow not created, expecting Json data");
        }
        // Parse JSON file
        Long follower = Long.parseLong(json.findPath("follower").asText());
        Long followee = Long.parseLong(json.findPath("followee").asText());
        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat(Common.DATE_PATTERN);
        try {
            time = format.parse(json.findPath("time").asText());
        } catch (ParseException e) {
            System.out.println("No creation date specified, set to current time");
        }

        try {
            Follow follow = new Follow(follower, followee, time);
            followRepository.save(follow);
            System.out.println("follow saved: " + follow.getId());
            return created(new Gson().toJson(follow.getId()));
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println(followee + "\n" + follower);
            System.out.println("Like not saved:a " + follower);
            return badRequest("Like not saved:s " + follower);
        }
    }

    public Result deleteFollowById(long id){
        Follow deleteFollow = followRepository.findOne(id);
        if (deleteFollow == null) {
            System.out.println("Follow not found with id: " + id);
            return badRequest("Follow not found with id: " + id);
        }

        followRepository.delete(id);
        JsonArray result = new JsonArray();
        JsonObject a = new JsonObject();
        a.addProperty("response", "Follow is deleted: " + id);
        result.add(a);
        return created(result.toString());
    }

}
