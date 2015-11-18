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

import java.util.ArrayList;
import java.util.List;

import models.User;
import models.UserRepository;
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
@Named @Singleton public class PostController extends Controller {

    private final PostRepository postRepository;

    // We are using constructor injection to receive a repository to support our
    // desire for immutability.
    @Inject public PostController(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Result addPost() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Posy not created, expecting Json data");
            return badRequest("Post not created, expecting Json data");
        }
        // Parse JSON file
        String postId = json.path("postId").asText();
        String userId = json.path("userId").asText();
        int comment = Integer.parseInt(json.path("comment").asText());
        int like = Integer.parseInt(json.path("like").asText());
        int privacy = Integer.parseInt(json.path("privacy").asText());
        String text = json.path("text").asText();
        String time = json.path("time").asText();

        try {
            Post post = new Post(postId, userId, comment, like, privacy, text, time);
            postRepository.save(post);
            System.out.println("Post saved: " + post.getId());
            return created(new Gson().toJson(post.getId()));
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("post not saved: " + postId + " " + userId);
            return badRequest("post not saved: " + postId + " " + userId);
        }
    }

    public Result getPublicPost() {
    }

    public Result getPersonalPost() {
    }

    public Result updatePost() {
    }

    public Result deletePost() {
        Post deletePost = postRepository.findOne(id);
        if (deleteUser == null) {
            System.out.println("Post not found with id: " + id);
            return notFound("Post not found with id: " + id);
        }

        List<Post> deletePosts=postRepository.findPostsById(deletePost.getId());
        for(Post deletePost:deletePosts) {
            userRepository.delete(deletePost);
            System.out.println("Post is deleted: " + deletePost.getId());
        }
        return ok("Post is deleted: " + id);
    }

}
