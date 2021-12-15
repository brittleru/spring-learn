package com.example;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${swim.email}")
    private String email;

    @Value("${swim.team}")
    private String team;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune() + " From: " + getClass().getSimpleName();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
