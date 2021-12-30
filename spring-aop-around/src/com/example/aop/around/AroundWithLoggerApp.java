package com.example.aop.around;

import com.example.aop.around.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerApp {

    // built-in logger in java
    private static Logger logger = Logger.getLogger(AroundWithLoggerApp.class.getName());
    
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // get the bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("\nMain Program: AroundApp");
        logger.info("Calling getFortune()");

        String data = trafficFortuneService.getFortune();
        logger.info("\nMy fortune is: " + data);

        logger.info("Finished");

        // close the context
        context.close();

    }

}
