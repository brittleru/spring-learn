package com.example.aop.around.dao;


import com.example.aop.around.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the target object
 */
@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    // add a new method: findAccounts()

    public List<Account> findAccounts(boolean tripWire) {

        // for academic purpose ... simulate an exception
        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }


        List<Account> accounts = new ArrayList<>();

        // create sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Medi", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        // add them to our accounts list
        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);

        return accounts;
    }

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
