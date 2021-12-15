package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeAnnotationApp {

    public static void main(String[] args) {
        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from spring container
        Coach coach = context.getBean("pingPongCoach",  Coach.class);

        // call a method on the bean
        System.out.println(coach.getDailyWorkout());

        // call a method on the bean
        System.out.println(coach.getDailyFortune());

        // close the context
        context.close();
    }
}
