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

package models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import util.APICall;
import util.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserSet {

	private String id;
	private String username;
	private String password;
	
	public String getUsername() {
		return password;
	}
	
	public String getPassword() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	private static final String GET_ALL_USERSET = Constants.NEW_BACKEND + "userset/getAllUsersets/json";
	private static final String USERSET_QUERY = Constants.NEW_BACKEND + "userset/queryUserset";
	
	public static List<UserSet> all() {

		List<UserSet> userSets = new ArrayList<UserSet>();

		JsonNode userSetNode = APICall.callAPI(GET_ALL_USERSET);

		if (userSetNode == null || userSetNode.has("error")
				|| !userSetNode.isArray()) {
			return userSets;
		}

		for (int i = 0; i < userSetNode.size(); i++) {
			JsonNode json = userSetNode.path(i);
			UserSet userset = new UserSet();
			userset.setUsername(json.get("userName").asText());
			userset.setPassword(json.get("password").asText());

			userSets.add(userset);
		}
		return userSets;
	}
	
	public static List<UserSet> queryUserSet(String username, String password) {
		
		List<UserSet> userSets = new ArrayList<UserSet>();
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode queryJson = mapper.createObjectNode();
		queryJson.put("userName", username);
		queryJson.put("password", password);

		JsonNode userSetNode = APICall.postAPI(USERSET_QUERY, queryJson);
		
		if (userSetNode == null || userSetNode.has("error")
				|| !userSetNode.isArray()) {
			return userSets;
		}

		for (int i = 0; i < userSetNode.size(); i++) {
			JsonNode json = userSetNode.path(i);
			UserSet newUserSet = deserializeJsonToUserSet(json);
			userSets.add(newUserSet);
		}
		return userSets;
	}

	private static UserSet deserializeJsonToUserSet(JsonNode json) {
		UserSet newUserSet = new UserSet();
		newUserSet.setUsername(json.get("userName").asText());
		newUserSet.setPassword(json.get("password").asText());

		return newUserSet;
	}
}
