package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

    // the qualifier annotation can be used for each type of injection (field / constructor / setter)
    // field injection directly so we don't need setters or constructors using Reflexion
    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

    // define a default constructor
    public TennisCoach() {
        System.out.println(">> inside default constructor - " + getClass().getSimpleName());
    }

    // define my init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
    }

    // define my destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
    }


//    @Autowired
//    public void doSomeCrazyStuff(FortuneService fortuneService) {
//        System.out.println(">> inside default doSomeCrazyStuff() method - " + getClass().getSimpleName());
//        this.fortuneService = fortuneService;
//    }

    // define a setter method for setter injection
//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        System.out.println(">> inside default setFortuneService() method - " + getClass().getSimpleName());
//        this.fortuneService = fortuneService;
//    }

//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune() + " " + getClass().getSimpleName();
    }

}
