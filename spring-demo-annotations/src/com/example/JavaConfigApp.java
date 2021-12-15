package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigApp {

    public static void main(String[] args) {

        // read spring config JAVA CLASS with NO XML
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container with the annotation name
        Coach coach = context.getBean("tennisCoach", Coach.class);
        Coach javaCoach = context.getBean("javaCoach", Coach.class);
        Coach pingPongCoach = context.getBean("pingPongCoach", Coach.class);

        // call some methods on the bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(javaCoach.getDailyWorkout());
        System.out.println(pingPongCoach.getDailyWorkout());

        // call method to get the daily fortune
        System.out.println(coach.getDailyFortune());
        System.out.println(javaCoach.getDailyFortune());
        System.out.println(pingPongCoach.getDailyFortune());


        // close the context
        context.close();

    }

}
