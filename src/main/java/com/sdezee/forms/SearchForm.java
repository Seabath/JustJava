package main.java.com.sdezee.forms;

import main.java.com.sdezee.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchForm {

    private static final String FORM_LOGIN = "login";

    private String result;

    private Map<String, String> errors = new HashMap<String, String>();


    public Map<String, String> getErrors() {
        return errors;
    }

    public String getResult() {
        return result;
    }

    public List<User> searchUsers(HttpServletRequest req) {
        String login = getValueForm(req, FORM_LOGIN);
        List<User> users = new ArrayList<User>();

        users = User.getUsers(login);

        return users;
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
