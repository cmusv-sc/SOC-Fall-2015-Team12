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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.PostSet;
import models.User;
import models.metadata.ClimateService;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.APICall;
import util.APICall.ResponseType;
import util.Constants;
import views.html.climate.*;

public class SearchController extends Controller {

    final static Form<User> usersetForm = Form
            .form(User.class);

    static String preKey = "";
    static String preStatus = "fuzzy";

    public static Result searchUser() throws Exception {

        String userId = session().get("userId");
        return ok(searchUsers.render(User.search("", userId,"accurate"), User.getFollowerList(userId), User.getTopFollowee(), usersetForm));
    }

    public static Result searchUserClick() throws Exception {
        Form<User> nu = usersetForm.bindFromRequest();
        String userId = session().get("userId");
        String keyword = nu.field("userName").value();
        String searchStatus = nu.field("searchStatus").value();
        System.out.println("searchStatus "+searchStatus);
        preKey = keyword;
        preStatus=searchStatus;
        System.out.println("userId " + userId + " keyword: " + keyword);
        return ok(searchUsers.render(User.search(keyword, userId,searchStatus), User.getFollowerList(userId), User.getTopFollowee(), usersetForm));
//		return redirect("/searchPosts");
    }

    public static Result addfollow() throws Exception {
        DynamicForm df = DynamicForm.form().bindFromRequest();
        String followee = df.field("idHolder").value();
        String follower = session().get("userId");
        String followId = df.field("followId").value();

        if (followId.equals("0")) {

            System.out.println(follower + " Will follow: " + followee);

            ObjectNode jsonData = Json.newObject();
            try {
                jsonData.put("follower", follower);
                jsonData.put("followee", followee);
                JsonNode response = APICall.postAPI(Constants.NEW_BACKEND + "follow/add", jsonData);
            } catch (IllegalStateException e) {
                e.printStackTrace();
                Application.flashMsg(APICall
                        .createResponse(ResponseType.CONVERSIONERROR));
            } catch (Exception e) {
                e.printStackTrace();
                Application.flashMsg(APICall.createResponse(ResponseType.UNKNOWN));
            }
        } else {
            JsonNode response = APICall.callAPI(Constants.NEW_BACKEND + "follow/delete/" + followId);
        }
        return redirect("/searchUsersClick?userName=" + preKey+"&searchStatus="+preStatus);
    }

    public static Result isFollowExisted() {
        JsonNode json = request().body().asJson();
        String follower = session().get("userId");
        String followee = json.path("followee").asText();

        ObjectNode jsonData = Json.newObject();
        JsonNode response = null;
        try {
            jsonData.put("followee", followee);
            jsonData.put("follower", follower);
            response = APICall.postAPI(Constants.NEW_BACKEND
                    + "/follow/isExisted", jsonData);
            Application.flashMsg(response);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            Application.flashMsg(APICall
                    .createResponse(ResponseType.CONVERSIONERROR));
        } catch (Exception e) {
            e.printStackTrace();
            Application.flashMsg(APICall
                    .createResponse(ResponseType.UNKNOWN));
        }
        return ok(response);
    }
}
