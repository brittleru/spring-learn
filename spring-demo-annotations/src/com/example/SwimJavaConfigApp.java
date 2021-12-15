package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
        Coach javaCoach = context.getBean("endavaCoach", Coach.class);

        // call method on the bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(javaCoach.getDailyWorkout());

        // call method to get the daily fortune
        System.out.println(coach.getDailyFortune());
        System.out.println(javaCoach.getDailyFortune());

        // call our new swim coach methods ... has the properties values injected
        System.out.println("Email: " + coach.getEmail());
        System.out.println("Team: " + coach.getTeam());

        // close the context
        context.close();
    }

}
