package com.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SadFortuneService implements FortuneService {

    private ArrayList<String> fortunes = new ArrayList<>(3);


    @Override
    public String getFortune() {
        fortunes.add("Unlucky!");
        fortunes.add("C@a!");
        fortunes.add("Cash me outside how about that");

//        return fortunes.get(ThreadLocalRandom.current().nextInt(fortunes.size()));
        return fortunes.get(new Random().nextInt(fortunes.size()));
    }
}
