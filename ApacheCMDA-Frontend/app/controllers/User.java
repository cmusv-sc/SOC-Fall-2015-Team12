package controllers;

import models.UserSet;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.mvc.*;
import play.data.Form;
import util.APICall;
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

    public static Result login() {return ok(login.render(userSetForm));}

    public static Result signup() {return ok(signup.render("test"));}

    public static Result getLoginResult(){
        Form<UserSet> dc = userSetForm.bindFromRequest();
        ObjectNode jsonData = Json.newObject();
        String username = "";
        String password = "";

        try {
            username = dc.field("Username").value();
            password = dc.field("Password").value();
            } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        List<UserSet> response = UserSet.queryUserSet(username, password);
        return ok(userSetList.render(response, userSetForm));
    }
}
