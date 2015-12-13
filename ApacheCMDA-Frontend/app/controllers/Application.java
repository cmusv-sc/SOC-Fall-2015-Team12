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

import java.util.Iterator;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import models.User;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import util.Constants;
import util.APICall;
import util.APICall.ResponseType;
import views.html.climate.*;

public class Application extends Controller {

	final static Form<User> userForm = Form
			.form(User.class);
	static String userID = "default";
	static String userString = "";

	public static class Login {

		public String email=userID;
		public String password=userString;
//		public String currentAddress;
//		public double latitude;
//		public double longitude;

		public String validate() {
			ObjectNode jsonData = Json.newObject();
			jsonData.put("email", email);
			jsonData.put("password", password);
			System.out.println("validate2 " + email);
			System.out.println("validate2 " + password);
			// POST Climate Service JSON data
			JsonNode response = APICall.postAPI(Constants.NEW_BACKEND
					+ Constants.USER_LOG_IN, jsonData);
			userString = response.toString();
			if (response.toString().contains("error")) {
				return "Invalid user or password";
			}
			return null;
		}

	}

	public static Result home() {
		return ok(home.render("", "", ""));
	}

	public static Result login() {
		return ok(login.render(Form.form(Login.class)));
	}

	public static Result logout() {
		session().clear();
		flash("success", "You've been logged out");
		return redirect(routes.Application.login());
//		return redirect(routes.ClimateServiceController.home(null, null, null));
	}

	public static Result createSuccess(){
		return ok(createSuccess.render());
	}

	public static Result authenticate() {
		DynamicForm df = DynamicForm.form().bindFromRequest();
		userID=df.field("email").value();
		userString=df.field("password").value();
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm));
		} else {

			JsonParser parser = new JsonParser();
			JsonObject UserJson = parser.parse(userString).getAsJsonObject();
			userID = UserJson.get("id").toString();
			String userName = UserJson.get("userName").toString();
			userName = userName.substring(1, userName.length() - 1);
			String firstName = UserJson.get("firstName").toString();
			firstName = firstName.substring(1, firstName.length() - 1);
			String lastName = UserJson.get("lastName").toString();
			lastName = lastName.substring(1, lastName.length() - 1);
			String email = UserJson.get("email").toString();
			email = email.substring(1, email.length() - 1);
			String affiliation = "";
			if (UserJson.get("affiliation")!= null) {
				affiliation = UserJson.get("affiliation").toString();
				affiliation = affiliation.substring(1, affiliation.length() - 1);
			}

			String researchInterests = "";
			if(UserJson.get("researchInterests")!=null) {
				researchInterests = UserJson.get("researchInterests").toString();
				researchInterests = researchInterests.substring(1, researchInterests.length() - 1);
			}

			String phoneNumber = "";
			if(UserJson.get("phoneNumber")!=null) {
				phoneNumber = UserJson.get("phoneNumber").toString();
				phoneNumber = phoneNumber.substring(1, phoneNumber.length() - 1);
			}

			System.out.println("UserId: " + userID + " User name: " + userName + " Email: " + email + " Affiliation: " + affiliation +
					" Resarch Interests: " + researchInterests + " Phone Number: " + phoneNumber);

			session().clear();
			session("userId", userID);
			session("userName", userName);
			session("firstName", firstName);
			session("lastName", lastName);
			session("email", loginForm.get().email);
			session("affiliation", affiliation);
			session("researchInterests", researchInterests);
			session("phoneNumber", phoneNumber);

//			double latitude = loginForm.get().latitude;
//			double longitude = loginForm.get().longitude;
//			String address = loginForm.get().currentAddress;

//			System.out.println("Login location test");
//			System.out.println("Lat: "+ latitude +" Long: "+ longitude +" Address: " + address);

//			session();
			return redirect("/mainpage");
//;
		}
	}

	public static void flashMsg(JsonNode jsonNode){
		Iterator<Entry<String, JsonNode>> it = jsonNode.fields();
		while (it.hasNext()) {
			Entry<String, JsonNode> field = it.next();
			flash(field.getKey(),field.getValue().asText());
		}
	}

	public static Result signup() {

		return ok(signup.render(userForm));
	}


	public static Result createNewUser(){
		Form<User> nu = userForm.bindFromRequest();



		ObjectNode jsonData = Json.newObject();
		String userName = null;

		try{
//			userName = nu.field("firstName").value()+" "+(nu.field("middleInitial")).value()
//					+" "+(nu.field("lastName")).value();
//			jsonData.put("userName", userName);
			jsonData.put("firstName", nu.get().getFirstName());
			jsonData.put("middleInitial", nu.get().getMiddleInitial());
			jsonData.put("lastName", nu.get().getLastName());
			jsonData.put("password", nu.get().getPassword());
			jsonData.put("affiliation", nu.get().getAffiliation());
			jsonData.put("title", nu.get().getTitle());
			jsonData.put("email", nu.get().getEmail());
			jsonData.put("mailingAddress", nu.get().getMailingAddress());
			jsonData.put("phoneNumber", nu.get().getPhoneNumber());
			jsonData.put("researchInterests", nu.get().getResearchFields());
			jsonData.put("highestDegree", nu.get().getHighestDegree());

			JsonNode response = APICall.postAPI(Constants.NEW_BACKEND
					+ Constants.ADD_USER, jsonData);

			// flash the response message
			Application.flashMsg(response);
			return redirect(routes.Application.createSuccess());

		}catch (IllegalStateException e) {
			e.printStackTrace();
			Application.flashMsg(APICall
					.createResponse(ResponseType.CONVERSIONERROR));
		} catch (Exception e) {
			e.printStackTrace();
			Application.flashMsg(APICall
					.createResponse(ResponseType.UNKNOWN));
		}
		return ok(signup.render(nu));
	}

	public static Result isEmailExisted() {
		JsonNode json = request().body().asJson();
		String email = json.path("email").asText();

		ObjectNode jsonData = Json.newObject();
		JsonNode response = null;
		try {
			jsonData.put("email", email);
			response = APICall.postAPI(Constants.NEW_BACKEND
					+ Constants.IS_EMAIL_EXISTED, jsonData);
			Application.flashMsg(response);
		}catch (IllegalStateException e) {
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
