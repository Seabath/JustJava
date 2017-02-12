package main.java.com.sdezee.servlets;

import main.java.com.sdezee.entities.User;
import main.java.com.sdezee.forms.SearchForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class Delete extends HttpServlet {


    public static final String ATT_SESSION_USER = "sessionUser";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User sessionUser = (User) session.getAttribute(ATT_SESSION_USER);
        if (sessionUser == null) {
            resp.sendRedirect("/");
            return;
        }

        int id = Integer.parseInt(req.getParameter("id"));
        User user = User.getUser(id);
        user.deleteDatabase();

        resp.sendRedirect("/search");
    }
}
