package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.example")  // no need for this (optional)
@PropertySource("classpath:sport.properties")
public class SportConfig {

    // define bean for our sad fortune service, the method name is the bean ID that is registered
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }
    @Bean
    public FortuneService codingFortune() {
        return new CodingFortune();
    }

    // define bean for our swim coach AND inject dependency for him
    @Bean
    public Coach swimCoach() {
        // we need to call the method inside the SwimCoach parameter
        return new SwimCoach(this.sadFortuneService());
    }

    @Bean
    public Coach endavaCoach() {
        return new EndavaCoach(this.codingFortune());
    }



}
