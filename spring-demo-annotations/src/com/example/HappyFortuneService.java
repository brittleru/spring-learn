package com.example;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

    private FortuneService fortuneService;

    @Override
    public String getFortune() {
        return "Today is your lucky day, with love, from:";
    }

}
