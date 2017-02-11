package main.java.com.sdezee.main;

import main.java.com.sdezee.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        User emp = new User();
        emp.setLogin("Seabath");
        emp.setPassword("trésécur");


        int i = emp.insertDatabase();
        System.out.println(String.format("Nouvel ID: %d", i));
    }
}
