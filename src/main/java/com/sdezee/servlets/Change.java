package main.java.com.sdezee.servlets;

import main.java.com.sdezee.entities.User;
import main.java.com.sdezee.forms.ChangeForm;
import main.java.com.sdezee.forms.CreateForm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Change extends HttpServlet {

    public static final String ATT_USER = "user";
    public static final String ATT_FORM = "form";
    public static final String ATT_SESSION_USER = "sessionUser";
    public static final String PAR_ID = "id";
    public static final String VIEW = "/WEB-INF/change.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute(ATT_SESSION_USER) == null) {
            resp.sendRedirect("/login");
            return;
        }
        int id = Integer.parseInt(req.getParameter(PAR_ID));
        User user = User.getUser(id);
        session.setAttribute(ATT_USER, user);
        this.getServletContext().getRequestDispatcher(VIEW).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(ATT_USER);

        ChangeForm form = new ChangeForm();
        form.updateUser(req, user);

        if (form.getErrors().isEmpty()) {
            boolean b = user.updateDatabase();
            if (b) {
                form.setResult("success");
                req.setAttribute(ATT_USER, user);
            }
            else {
                form.setResult("failed");
                req.setAttribute(ATT_FORM, form);
            }
        }

        req.setAttribute(ATT_USER, user);

        this.getServletContext().getRequestDispatcher(VIEW).forward(req, resp);
    }
}
