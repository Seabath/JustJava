package main.java.com.sdezee.servlets;

import main.java.com.sdezee.entities.User;
import main.java.com.sdezee.forms.LoginForm;

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
        HttpSession session = req.getSession();
        session.setAttribute(ATT_USER, null);
        this.getServletContext().getRequestDispatcher(VIEW).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginForm form = new LoginForm();
        User user = form.connectUser(req);

        HttpSession session = req.getSession();

        if (form.getErrors().isEmpty()) {
            session.setAttribute(ATT_USER, user);
            resp.sendRedirect("/index");
            return;
        }
        else
            session.setAttribute(ATT_USER, null);

        req.setAttribute(ATT_FORM, form);
        req.setAttribute(ATT_USER, user);

        this.getServletContext().getRequestDispatcher(VIEW).forward(req, resp);
    }
}
