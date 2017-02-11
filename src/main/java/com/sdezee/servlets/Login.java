package main.java.com.sdezee.servlets;

import main.java.com.sdezee.entities.User;
import main.java.com.sdezee.forms.LoginForm;
import main.java.com.sdezee.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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


    private User getUserById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from USER where id= :id");
        query.setLong("id", id);

        User user = (User) query.uniqueResult();
        session.getTransaction().commit();
        return user;
    }

    private User getUserByLogin(String login) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from USER where login= :login");
        query.setString("login", login);

        User user = (User) query.uniqueResult();
        session.getTransaction().commit();
        return user;
    }
}
