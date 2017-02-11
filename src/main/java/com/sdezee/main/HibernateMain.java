package main.java.com.sdezee.main;

import main.java.com.sdezee.entities.User;
import main.java.com.sdezee.util.HibernateUtil;
import org.hibernate.Session;

public class HibernateMain {

    public static void main(String[] args) {
        User emp = new User();
        emp.setLogin("Seabath");
        emp.setPassword("trésécur");

        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("USER ID="+emp.getId());

        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
    }
}
