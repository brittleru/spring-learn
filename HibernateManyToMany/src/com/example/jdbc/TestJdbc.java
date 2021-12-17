package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false&serverTimezone=UTC";
        String username = "hbstudent";
        String password = "hbstudent";
        String password2 = "hbstudentzzzz";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            System.out.println("Connection successful!!!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
