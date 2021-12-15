package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JavaCoach implements Coach {

    private FortuneService fortuneService;

    public JavaCoach() {}

    @Autowired
    public JavaCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }


    @Override
    public String getDailyWorkout() {
        return "Run a haaaaard 5 mile";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune() + " " + getClass().getSimpleName();
    }

}
