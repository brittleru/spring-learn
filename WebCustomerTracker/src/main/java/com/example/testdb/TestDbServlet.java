package com.example.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
//@WebServlet("/TestDbServlet")
@WebServlet(name = "TestDbServlet")
public class TestDbServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        // setup connection variables
        String username = "springstudent";
        String password = "springstudent";
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.jdbc.Driver";

        // get connection to database
        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to database: " + jdbcUrl);
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            out.println("SUCCESS!!!");

            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e); // so we can see in the browser
        }



    }



}
