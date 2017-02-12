package main.java.com.sdezee.forms;

import main.java.com.sdezee.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ChangeForm {

    public static final String FORM_LOGIN = "login";
    private static final String FORM_PASS = "password";
    private static final String FORM_PASS2 = "password2";

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
        String password2 = getValueForm(req, FORM_PASS2);

        User user = new User();
        if (!checkLogin(login))
            errors.put(FORM_LOGIN, "Bad login");
        user.setLogin(login);

        if (!checkPassword(password, password2))
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

    private boolean checkPassword(String password, String password2) {
        boolean b = password != null && password2 != null;
        return b && password.equals(password2);
    }

    private static String getValueForm(HttpServletRequest req, String nameFom) {
        String ret = req.getParameter(nameFom);
        req.getParameter(nameFom);
        if (ret == null || ret.trim().length() == 0) {
            return null;
        }
        return ret;
    }

    public void addError(String key, String mess){
        errors.put(key, mess);
    }

    public void setResult(String mess) {
        result = mess;
    }
}
