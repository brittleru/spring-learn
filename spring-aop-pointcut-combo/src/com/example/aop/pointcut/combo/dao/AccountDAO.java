package com.example.aop.pointcut.combo.dao;

import com.example.aop.pointcut.combo.Account;
import org.springframework.stereotype.Component;

/**
 * This is the target object
 */
@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass().getSimpleName() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass().getSimpleName() + ": doWork()");
        return false;
    }



    public String getName() {
        System.out.println(getClass().getSimpleName() + ": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass().getSimpleName() + ": setName()");

    }

    public String getServiceCode() {
        System.out.println(getClass().getSimpleName() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass().getSimpleName() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }


}
