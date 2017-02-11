package main.java.com.sdezee.util;


import main.java.com.sdezee.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class HibernateUtil {

    private final static String CFG_PATH = "/resources/hibernate.cfg.xml";
    private final static String CFG_ANNOTATION_PATH = "/resources/hibernate.cfg.xml";


    private static SessionFactory sessionFactory;
    private static SessionFactory sessionAnnotationFactory;
    private static SessionFactory sessionJavaConfigFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure(CFG_PATH);


            ServiceRegistry serviceRegistry = new
                    StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }


    private static SessionFactory buildSessionAnnotationFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure(CFG_ANNOTATION_PATH);


            ServiceRegistry serviceRegistry = new
                    StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildSessionJavaConfigFactory() {
        try {
            Configuration configuration = new Configuration();

            Properties props = new Properties();
            props.put("hibernate.connection.driver_class",
                    "com.mysql.jdbc.Driver");
            props.put("hibernate.connection.url",
                    "jbdc:mysql://localhost/JustJava");
            props.put("hibernate.connection.username",
                    "java");
            props.put("hibernate.connection.password",
                    "java");
            props.put("hibernate.current_session_context_class",
                    "thread");

            configuration.setProperties(props);

            configuration.addAnnotatedClass(User.class);

            ServiceRegistry serviceRegistry = new
                    StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            sessionFactory = buildSessionFactory();
        return sessionFactory;
    }

    public static SessionFactory getSessionAnnotationFactory() {
        if (sessionAnnotationFactory == null)
            sessionAnnotationFactory = buildSessionAnnotationFactory();
        return sessionAnnotationFactory;
    }

    public static SessionFactory getSessionJavaConfigFactory() {
        if (sessionJavaConfigFactory == null)
            sessionJavaConfigFactory = buildSessionFactory();
        return sessionJavaConfigFactory;
    }
}
