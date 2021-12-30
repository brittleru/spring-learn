package com.example.aop.around;

import com.example.aop.around.dao.AccountDAO;
import com.example.aop.around.dao.MembershipDAO;
import com.example.aop.around.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // get membership bean from spring container
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method
        Account account = new Account();
        account.setLevel("Platinum");
        account.setName("Medu");
        accountDAO.addAccount(account, true);
        accountDAO.doWork();

        // call the accountDAO getter/setter methods
        System.out.println("");
        accountDAO.setName("euro");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        // call the membership business method
        membershipDAO.addAccount();
        membershipDAO.goToSleep();


        // close the context
        context.close();

    }

}
