package main.java.com.sdezee.main;

import main.java.com.sdezee.entities.User;

public class Main {

    public static void main(String[] args) {
        User emp = new User();
        emp.setLogin("Seabath");
        emp.setPassword("trésécur");


        int i = emp.insertDatabase();
        System.out.println(String.format("Nouvel ID: %d", i));
    }
}
