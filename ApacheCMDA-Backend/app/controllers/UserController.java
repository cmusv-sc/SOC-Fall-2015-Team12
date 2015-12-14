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

import java.io.File;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
 * The main set of web services.
 */
@Named
@Singleton
public class UserController extends Controller {

    private final UserRepository userRepository;
    private final FollowController followController;

    // We are using constructor injection to receive a repository to support our
    // desire for immutability.
    @Inject
    public UserController(final UserRepository userRepository, final FollowController followController) {
        this.userRepository = userRepository;
        this.followController = followController;
    }

    public Result addUser() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("User not created, expecting Json data");
            return badRequest("User not created, expecting Json data");
        }

        // Parse JSON file
        String userName = json.path("userName").asText();
        String password = json.path("password").asText();
        String firstName = json.path("firstName").asText();
        String lastName = json.path("lastName").asText();
        String email = json.path("email").asText();
        String affiliation = json.path("affiliation").asText();
        String researchInterests = json.path("researchInterests").asText();
        String phoneNumber = json.path("phoneNumber").asText();

        try {
            if (userRepository.findByUserName(userName).size()>0) {
                System.out.println("UserName has been used: " + userName);
                return badRequest("UserName has been used");
            }
            User user = new User(userName, password, firstName, lastName, email, affiliation, researchInterests, phoneNumber);
            userRepository.save(user);
            System.out.println("User saved: " + user.getId());
            return created(new Gson().toJson(user.getId()));
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("User not saved: " + firstName + " " + lastName);
            return badRequest("User not saved: " + firstName + " " + lastName);
        }
    }

    public Result deleteUser(Long id) {
        User deleteUser = userRepository.findOne(id);
        if (deleteUser == null) {
            System.out.println("User not found with id: " + id);
            return notFound("User not found with id: " + id);
        }

        File photo = new File("images/" + deleteUser.getId());
        if (photo.exists() && photo.isFile()) {
            photo.delete();
        }
        userRepository.delete(deleteUser);
        System.out.println("User is deleted: " + id);
        return ok("User is deleted: " + id);
    }

    public Result updateUser(long id) {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("User not saved, expecting Json data");
            return badRequest("User not saved, expecting Json data");
        }

        // Parse JSON file
        String firstName = json.path("firstName").asText();
        String lastName = json.path("lastName").asText();
        String email = json.path("email").asText();

        try {
            User updateUser = userRepository.findOne(id);

            updateUser.setFirstName(firstName);
            updateUser.setLastName(lastName);
            updateUser.setEmail(email);

            User savedUser = userRepository.save(updateUser);
            System.out.println("User updated: " + savedUser.getFirstName()
                    + " " + savedUser.getLastName());
            return created("User updated: " + savedUser.getFirstName() + " "
                    + savedUser.getLastName());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("User not updated: " + firstName + " "
                    + lastName);
            return badRequest("User not updated: " + firstName + " " + lastName);
        }
    }

    public Result getUser(Long id) {
        if (id == null) {
            System.out.println("User id is null or empty!");
            return badRequest("User id is null or empty!");
        }

        User user = userRepository.findOne(id);

        if (user == null) {
            System.out.println("User not found with with id: " + id);
            return notFound("User not found with with id: " + id);
        }
        String result = new Gson().toJson(user);
        return ok(result);
    }

    public Result getAllUsers(String format) {
        Iterable<User> userIterable = userRepository.findAll();
        List<User> userList = new ArrayList<User>();
        for (User user : userIterable) {
            userList.add(user);
        }
        String result = new String();
        if (format.equals("json")) {
            result = new Gson().toJson(userList);
        }
        return ok(result);
    }

    public Result isUserValid() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Cannot check user, expecting Json data");
            return badRequest("Cannot check user, expecting Json data");
        }
        String email = json.path("email").asText();
        String password = json.path("password").asText();

        User user = userRepository.findByEmail(email);
        if (user.getPassword().equals(password)) {
            System.out.println("User is valid");
            return ok("User is valid");
        } else {
            System.out.println("User is not valid");
            return badRequest("User is not valid");
        }
    }

    public Result deleteUserByUserNameandPassword(String userName, String password) {
        try {
            List<User> users = userRepository.findByUserName(userName);
            if (users.size() == 0) {
                System.out.println("User is not existed");
                return badRequest("User is not existed");
            }
            User user = users.get(0);
            if (user.getPassword().equals(password)) {
                System.out.println("User is deleted: " + user.getId());
                userRepository.delete(user);
                return ok("User is deleted");
            } else {
                System.out.println("User is not deleted for wrong password");
                return badRequest("User is not deleted for wrong password");
            }
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("User is not deleted");
            return badRequest("User is not deleted");
        }

    }

    public Result isEmailExisted() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Cannot check email, expecting Json data");
            return badRequest("Cannot check email, expecting Json data");
        }
        String email = json.path("email").asText();
        if (userRepository.findByEmail(email) != null) {
            return badRequest("Email already existed");
        }
        return ok("Email is valid");
    }


    public Result login() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("User info is wrong, expecting Json data");
            return badRequest("User info is wrong, expecting Json data");
        }

        // Parse JSON file
        String email = json.path("email").asText();
        String password = json.path("password").asText();

        if (userRepository.findByEmail(email) == null) {
            System.out.println("User not exist: " + email);
            return badRequest("User not exist");
        } else {
            User userLogin = userRepository.findByEmail(email);
            if (userLogin.getPassword().equals(password)) {
                return created(new Gson().toJson(userLogin));
            } else {
                System.out.println("Wrong password");
                return badRequest("Wrong password");
            }
        }
    }

    public Result signUp() {
//        JsonNode json = request().body().asJson();
//        if (json == null) {
//            System.out.println("User info is wrong, expecting Json data");
//            return badRequest("User info is wrong, expecting Json data");
//        }
//
//        // Parse JSON file
//        // The following attributes should be valid
//        String email = json.path("email").asText(); //email must be unique
//        if (userRepository.findByEmail(email) != null) {
//            System.out.println("Email has been used: " + email);
//            return badRequest("Email already existed");
//        } else {
//            String password = json.path("password").asText();
//            String firstName = json.path("firstName").asText();
//            String lastName = json.path("lastName").asText();
//            // userName can be generated automatically which is the same as the email prefix
//            String userName = email.split("@")[0];
//
//            try {
//                User user = new User(userName, password, firstName, lastName, email);
//                userRepository.save(user);
//                System.out.println("User saved: " + user.getId());
//                return created(new Gson().toJson(user.getId()));
//            } catch (PersistenceException pe) {
//                pe.printStackTrace();
//                System.out.println("User not saved: " + firstName + " " + lastName);
//                return badRequest("User not saved: " + firstName + " " + lastName);
//            }
//        }
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("User info is wrong, expecting Json data");
            return badRequest("User info is wrong, expecting Json data");
        }

        // Parse JSON file
        // The following attributes should be valid
        String email = json.path("email").asText(); //email must be unique
        if (userRepository.findByEmail(email) != null) {
            System.out.println("Email has been used: " + email);
            return badRequest("Email already existed");
        }
        else {
            String password = json.path("password").asText();
            String firstName = json.path("firstName").asText();
            String lastName = json.path("lastName").asText();
            // userName can be generated automatically which is the same as the email prefix
            String userName = firstName + " " + lastName;
            String affiliation = json.path("affiliation").asText();
            String researchInterests = json.path("researchInterests").asText();
            String phoneNumber = json.path("phoneNumber").asText();

            try {
                User user = new User(userName, password, firstName, lastName, email, affiliation, researchInterests, phoneNumber);
                userRepository.save(user);
                System.out.println("User saved: " + user.getId());
                return created(new Gson().toJson(user.getId()));
            }catch(PersistenceException pe){
                pe.printStackTrace();
                System.out.println("User not saved: " + firstName + " " + lastName);
                return badRequest("User not saved: " + firstName + " " + lastName);
            }
        }
    }

    public Result searchUser(String username, Long id, String status, String format) {
        username=username.replaceAll(":"," ");
        System.out.println("bend " + username);

        if (username == null || username.length() == 0) {
            System.out.println("username is null or empty!");
            return badRequest("username is null or empty!");
        }

        List<User> users;
        if (status.contains("fuzzy"))
            users = userRepository.searchUsers(username);
        else
            users = userRepository.searchExactUsers(username);

        if (users == null || users.size() == 0) {
            System.out.println("User not exist!");
            return badRequest("User not exist!");
        }

        //JsonObject result = new JsonObject();
        JsonArray userArray = new JsonArray();

        for (User user : users) {
            JsonObject userDetails = new JsonObject();
            userDetails.addProperty("id", user.getId());
            userDetails.addProperty("username", user.getUserName());
            userDetails.addProperty("count", followController.getCount(user.getId() + ""));
            userDetails.addProperty("followId", followController.isExisted(id, user.getId()));
            userArray.add(userDetails);
        }
        return ok(userArray.toString());
    }

    public Result uploadUserPhoto(Long id) {
        Http.MultipartFormData body = request().body().asMultipartFormData();

        Http.MultipartFormData.FilePart photo = body.getFile("photo");
        if (photo == null) {
            System.out.println("User photo not saved, expecting binary data");
            return notFound("User photon not saved, expecting binary data");
        }

        User user = userRepository.findOne(id);
        if (user == null) {
            System.out.println("User not found with id: " + id);
            return notFound("User not found with id: " + id);
        }

        File dir = new File("images");
        if (!dir.exists()) {
            dir.mkdir();
        }

        File oldFile = new File("images/" + user.getId());
        if (oldFile.exists() && oldFile.isFile()) {
            oldFile.delete();
        }

        File newFile = photo.getFile();
        String filename = newFile.getName();
		/*System.out.println("****************************");
		Map<String, String[]> headerMap = request().headers();
		for(Map.Entry<String, String[]> entry: headerMap.entrySet()) {
			System.out.println(entry.getKey());
			for(String s: entry.getValue()) {
				System.out.println("\t" + s);
			}
		}
		System.out.print(filename);*/
        user.setPhotoContentType(photo.getContentType());

        newFile.renameTo(new File("images/" + user.getId()));

        try {
            User savedUser = userRepository.save(user);
            System.out.println("User photo updated: " + savedUser.getFirstName()
                    + " " + savedUser.getLastName());
            return ok("User photo updated: " + savedUser.getFirstName() + " "
                    + savedUser.getLastName());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("User not updated: " + user.getFirstName() + " "
                    + user.getLastName());
            return badRequest("User not updated: " + user.getFirstName() + " " +
                    user.getLastName());
        }
    }

    public Result getUserPhoto(Long id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            System.out.println("User not found with id: " + id);
            return notFound("User not found with id: " + id);
        }

        File photo = new File("images/" + user.getId());
        if (!photo.exists() || !photo.isFile()) {
            System.out.println("User photo not found with id: " + id);
            return notFound("User photo not found with id: " + id);
        }

        response().setContentType(user.getPhotoContentType());
        return ok(photo);
    }


}
