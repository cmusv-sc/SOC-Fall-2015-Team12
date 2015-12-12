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
import models.User;
import models.UserRepository;
import play.mvc.*;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import util.Common;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

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
    private final UserRepository userRepository;

    // We are using constructor injection to receive a repository to support our
    // desire for immutability.
    @Inject public FollowController(final FollowRepository followRepository, final UserRepository userRepository) {
        this.followRepository = followRepository;
        this.userRepository=userRepository;
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
            System.out.println("follow not saved:a " + follower);
            return badRequest("follow not saved:s " + follower);
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

    public Long isExisted(Long follower, Long followee){

        System.out.println(follower + " " + followee);

        List<Follow> existedFollow = followRepository.check(follower,followee);

        if (existedFollow != null && !existedFollow.isEmpty()) {
            System.out.println("Follow is existed");
            System.out.println(existedFollow.get(0).getId());
            return existedFollow.get(0).getId();
        }else{
            return 0l;
        }
    }

    public Result getTopFollowee(){
        JsonArray result = new JsonArray();
        List<Object> existedFollow = followRepository.getTopFollwee(3l);
        for(Object id: existedFollow){
            JsonObject a = new JsonObject();
            User user=userRepository.findById(Long.parseLong(id.toString()));
            a.addProperty("id", user.getId());
            a.addProperty("count", getCount(id.toString()));
            a.addProperty("name", user.getUserName());
            result.add(a);
        }
        return created(result.toString());
    }

    public Result getFollowerById(long userId){
        JsonArray result = new JsonArray();
        List<Follow> existedFollow = followRepository.getFollowerById(userId);
        for(Follow follower: existedFollow){
            JsonObject a = new JsonObject();
            User user=userRepository.findById(follower.getFollower());
            System.out.println(user.getUserName());
            if(user==null)
                continue;
            a.addProperty("userId", follower.getId());
            a.addProperty("name", user.getUserName());
            result.add(a);
        }
        return created(result.toString());
    }

    public Long getCount(String id){
        return followRepository.countFollwer(id.toString());
    }

}
