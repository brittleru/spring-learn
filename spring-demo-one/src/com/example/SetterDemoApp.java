package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

    public static void main(String[] args) {

        // Load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the bean from the spring container
        CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);

        // Call methods on the bean
        // TODO: later xd
        System.out.println(cricketCoach.getDailyWorkout());
        System.out.println(cricketCoach.getDailyFortune());
        System.out.println(cricketCoach.getDailyFortune());
        System.out.println(cricketCoach.getDailyFortune());
        System.out.println(cricketCoach.getDailyFortune());

        // call our new methods to get the literal values
        System.out.println(cricketCoach.getEmailAddress());
        System.out.println(cricketCoach.getTeam());

        // Close the context
        context.close();
    }

}
