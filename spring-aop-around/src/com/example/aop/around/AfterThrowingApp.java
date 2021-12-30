package com.example.aop.around;

import com.example.aop.around.dao.AccountDAO;
import com.example.aop.around.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> accounts = null;

        try {
            // add a boolean flag to simulate exceptions
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        }
        catch (Exception e) {
            System.out.println("\n\nMain Program ... caught exception: " + e);
        }


        // display the accounts
        System.out.println("\n\nMain program for: AfterThrowingApp");
        System.out.println("------");

        System.out.println(accounts);

        System.out.println("\n");


        // close the context
        context.close();

    }

}
