package com.example.aop.ordering.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addAccount() {
        System.out.println(getClass().getSimpleName() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");

        return true;
    }

    public void goToSleep() {
        System.out.println(getClass().getSimpleName() + ": I'm going to sleep now... cy@ buddy");

    }
}
