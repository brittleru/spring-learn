package com.example.aop.dao;

import com.example.aop.Account;
import org.springframework.stereotype.Component;

/**
 * This is the target object
 */
@Component
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass().getSimpleName() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass().getSimpleName() + ": doWork()");
        return false;
    }

}
