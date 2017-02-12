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

public class Search extends HttpServlet {

    public static final String ATT_USERS = "users";
    public static final String ATT_FORM = "form";
    public static final String ATT_SESSION_USER = "sessionUser";
    public static final String VIEW = "/WEB-INF/search.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute(ATT_SESSION_USER) == null) {
            resp.sendRedirect("/login");
            return;
        }

        this.getServletContext().getRequestDispatcher(VIEW).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SearchForm form = new SearchForm();
        List<User> userList = form.searchUsers(req);

        req.setAttribute(ATT_FORM, form);
        req.setAttribute(ATT_USERS, userList);

        this.getServletContext().getRequestDispatcher(VIEW).forward(req, resp);
    }
}
