package main.java.com.sdezee.servlets;

import main.java.com.sdezee.entities.User;
import main.java.com.sdezee.forms.CreateForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Create extends HttpServlet {

    public static final String ATT_USER = "user";
    public static final String ATT_FORM = "form";
    public static final String ATT_SESSION_USER = "sessionUser";
    public static final String VIEW = "/WEB-INF/create.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VIEW).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateForm form = new CreateForm();
        User user = form.connectUser(req);

        HttpSession session = req.getSession();

        if (form.getErrors().isEmpty()) {
            session.setAttribute(ATT_USER, user);
            resp.sendRedirect("/");
            return;
        }
        else
            session.setAttribute(ATT_USER, null);

        req.setAttribute(ATT_FORM, form);
        req.setAttribute(ATT_USER, user);

        this.getServletContext().getRequestDispatcher(VIEW).forward(req, resp);
    }
}
