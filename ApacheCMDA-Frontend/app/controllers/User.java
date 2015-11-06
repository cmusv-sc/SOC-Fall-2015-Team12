package controllers;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.UserSet;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.mvc.*;
import play.data.Form;
import util.APICall;
import util.Constants;
import views.html.climate.*;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import play.libs.Json;
import java.util.List;

/**
 * Created by Qiyao on 11/5/15.
 */
public class User extends Controller {
    final static Form<UserSet> userSetForm = Form
            .form(UserSet.class);

    private static final String USERSET_QUERY = Constants.NEW_BACKEND + "userService/login";
    private static final String USERSET_QUERYTEST = Constants.NEW_BACKEND + "userService/loginTest/json";

    public static Result login() {return ok(login.render(userSetForm));}

    public static Result signup() {return ok(signup.render("guest"));}

    public static Result getLoginResult(){

        Form<UserSet> dc = userSetForm.bindFromRequest();
        ObjectNode jsonData = Json.newObject();
        String username = "";
        String password = "";

        try {
            username = dc.field("userName").value();
            password = dc.field("password").value();
            } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        List<UserSet> userSets = new ArrayList<UserSet>();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode queryJson = mapper.createObjectNode();
        queryJson.put("userName", username);
        queryJson.put("password", password);
        //JsonNode userSetNode = APICall.postAPI(USERSET_QUERY, queryJson);
        JsonNode userSetNode = APICall.callAPI(USERSET_QUERYTEST);
        if (userSetNode == null || userSetNode.has("error")
            || !userSetNode.isArray()) {
            return ok(signup.render("error"));
        }
        JsonNode json = userSetNode.path(0);
        return ok(signup.render(json.get(username).asText()));
        //List<UserSet> response = UserSet.queryUserSet(username, password);
        //return ok(userSetList.render(response, userSetForm));
    }
}
