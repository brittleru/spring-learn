package com.example.aop.after;

import com.example.aop.after.dao.AccountDAO;
import com.example.aop.after.dao.MembershipDAO;
import com.example.aop.after.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturingApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> accounts = accountDAO.findAccounts();

        // display the accounts
        System.out.println("\n\nMain program for: AfterReturningApp");
        System.out.println("------");

        System.out.println(accounts);

        System.out.println("\n");


        // close the context
        context.close();

    }

}
