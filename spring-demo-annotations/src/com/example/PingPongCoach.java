package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PingPongCoach implements Coach {

    // how to read values from a properties file to not hardcode it into java go to xml to see how to import the file
    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    @Autowired
    @Qualifier("databaseFortuneService")
    private FortuneService fortuneService;

    // define a default constructor
    public PingPongCoach() {
        System.out.println(">> inside default constructor - " + getClass().getSimpleName());
        System.out.println(getClass().getSimpleName() + " contact:\n\tEmail: " + getEmail() + "\n\tTeam:" + getTeam());
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @PostConstruct
    public void postConstructMethod() {
        System.out.println(">> Inside method -> postConstructMethod(): " + fortuneService.getFortune() + " " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your ping-pong drop show!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune() + getClass().getSimpleName();
    }
}
