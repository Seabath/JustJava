package main.java.com.sdezee.forms;

import main.java.com.sdezee.entities.User;

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

        User user;
        if (!checkLogin(login))
            errors.put(FORM_LOGIN, "Bad login");
        user = User.getUser(login);
        if (!checkPassword(password))
            errors.put(FORM_PASS, "Bad password");
        if (!user.getPassword().equals(password))
            errors.put(FORM_PASS, "Bad password");

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
