package main.java.com.sdezee.servlets;

import main.java.com.sdezee.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class Index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "";
        HttpSession session = req.getSession();
        User users = (User) session.getAttribute("user");
        if (users == null)
            message = "";
        else message = users.getLogin();

        req.setAttribute( "user", message );
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
