package com.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    // create an array of strings
    private final ArrayList<String> fortunes = new ArrayList<>(3);

    // create a random number generator
    private Random random = new Random();

    @Override
    public String getFortune() {
        fortunes.add("Beware of the wolf in sheep's clothing");
        fortunes.add("Diligence is the mother of good luck");
        fortunes.add("The journey is the reward");

        int index = random.nextInt(fortunes.size());

        return fortunes.get(index) + "... from:";
    }

}
