package com.sdzee.servlets;

import com.sdezee.entities.User;
import com.sdezze.forms.LoginForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet {

    public static final String ATT_USER = "user";
    public static final String ATT_FORM = "form";
    public static final String ATT_SESSION_USER = "sessionUser";
    public static final String VIEW = "/WEB-INF/login.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VIEW).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginForm form = new LoginForm();
        User user = form.connectUser(req);

        HttpSession session = req.getSession();

        if (!form.getErrors().isEmpty()) {
            session.setAttribute(ATT_USER, user);
            resp.sendRedirect("/untitled_war_exploded/index");
        }
        else
            session.setAttribute(ATT_USER, null);

        req.setAttribute(ATT_FORM, form);
        req.setAttribute(ATT_USER, user);

        this.getServletContext().getRequestDispatcher(VIEW).forward(req, resp);
    }
}
