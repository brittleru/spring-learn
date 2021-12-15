package com.example;

public class EndavaCoach implements Coach {

    private FortuneService fortuneService;

    public EndavaCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Inverse a binary tree as a warm up.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune() + ": From " + getClass().getSimpleName();
    }

}
