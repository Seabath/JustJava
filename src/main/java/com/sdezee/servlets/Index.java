package main.java.com.sdezee.servlets;

import main.java.com.sdezee.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class Index extends HttpServlet {

    public static final String ATT_SESSION_USER = "sessionUser";
    private static final String VIEW = "/WEB-INF/index.jsp";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "";
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(ATT_SESSION_USER);
        if (user == null) {
            resp.sendRedirect("/");
            return;
        }

        this.getServletContext().getRequestDispatcher(VIEW).forward(req, resp);
    }
}
