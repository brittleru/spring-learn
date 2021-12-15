package com.example;

import org.springframework.beans.factory.DisposableBean;

public class CricketCoach implements Coach, DisposableBean {

    private FortuneService fortuneService;

    // add new fields for emailAddress and team
    private String emailAddress;
    private String team;

    // create a no argument constructor for spring toc all
    public CricketCoach() {
        System.out.println("Cricket Coach: inside no-arg constructor");
    }

    // setter method called by spring when we inject the dependency
    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println(this.getClass().getName() + ": inside setter method " + this.getClass().getEnclosingClass().getName());
        System.out.println("Cricket Coach: inside setter method - setFortuneService");
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("Cricket Coach: inside setter method - setEmailAddress");
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("Cricket Coach: inside setter method - setTeam");
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    //  add an init method
    public void initializationMethod() {
        System.out.println("CricketCoach: inside method initializationMethod");
    }

    // add a destroy method
//    public void destroyMethod() {
//        System.out.println("CricketCoach: inside method destroyMethod");
//    }

    @Override
    public void destroy() throws Exception {
        System.out.println("CricketCoach: inside method destroyMethod");
    }
}
