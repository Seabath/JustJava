package main.java.com.sdezee.entities;

import java.sql.*;

public class User {


    private final static String DB_URL = "jdbc:mysql://localhost/JustJava";
    private final static String DB_USER = "java";
    private final static String DB_PASS = "java";

    private int id;

    private String login;
    private String password;

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int insertDatabase() {
        String st = "select insert_user(\"" +
                login + "\", \"" + password + "\") as id";
        Connection connection = null;
        ResultSet resultSet;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(st);
            resultSet.next();
            id = resultSet.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return id;
    }

    public static User getUser(String login) {
        User user = new User();
        String st = "select id, login, password from USER where login = \"" + login + "\"";
        Connection connection = null;
        ResultSet resultSet;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(st);
            resultSet.next();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }
}
