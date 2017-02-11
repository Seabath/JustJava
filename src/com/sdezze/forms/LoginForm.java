package com.sdezze.forms;

import com.sdezee.entities.User;
import sun.net.httpserver.HttpServerImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class LoginForm {

    private static final String FORM_LOGIN = "login";
    private static final String FORM_PASS = "password";

    private String result;

    private Map<String, String> errors = new HashMap<String, String>();


    public Map<String, String> getErrors() {
        return errors;
    }

    public String getResult() {
        return result;
    }

    public User connectUser(HttpServletRequest req) {
        String login = getValueForm(req, FORM_LOGIN);
        String password = getValueForm(req, FORM_PASS);

        User user = new User();
        if (!checkLogin(login))
            errors.put(FORM_LOGIN, "Bad login");
        user.setLogin(login);
        if (!checkPassword(password))
            errors.put(FORM_PASS, "Bad password");

        user.setPassword(password);

        if (errors.isEmpty())
            result = "Success";
        else
            result = "Failure";
        return user;
    }

    private boolean checkLogin(String login) {
        return login != null;
    }

    private boolean checkPassword(String password) {
        return  password != null;
    }

    private static String getValueForm(HttpServletRequest req, String nameFom) {
        String ret = req.getParameter(nameFom);
        req.getParameter(nameFom);
        if (ret == null || ret.trim().length() == 0) {
            return null;
        }
        return ret;
    }
}
