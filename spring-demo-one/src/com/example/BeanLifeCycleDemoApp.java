package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        // Retrieve bean from spring container
        Coach coach = context.getBean("myCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());

        CricketCoach cricketCoach = (CricketCoach) context.getBean("customProcessor", Coach.class);

        System.out.println(cricketCoach.getDailyWorkout());
        // For prototype scoped beans, spring does not call destroy method

        // close the context
        context.close();
    }

}
