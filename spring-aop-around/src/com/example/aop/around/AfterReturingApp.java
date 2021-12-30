package com.example.aop.around;

import com.example.aop.around.dao.AccountDAO;
import com.example.aop.around.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturingApp {

    public static void main(String[] args) {
        double begin = System.currentTimeMillis();

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> accounts = accountDAO.findAccounts(false);

        // display the accounts
        System.out.println("\n\nMain program for: AfterReturningApp");
        System.out.println("------");

        System.out.println(accounts);

        System.out.println("\n");

        System.out.println("Time: " + ((System.currentTimeMillis() - begin) / 1000) + "s");
        // close the context
        context.close();

    }

}
