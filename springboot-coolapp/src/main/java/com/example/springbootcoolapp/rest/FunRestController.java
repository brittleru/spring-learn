package com.example.springbootcoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    // inject properties for coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}") // this will load from the application.properties
    private String teamName;

    // expose "/" endpoint that will return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Time on the server is " + LocalDateTime.now() +
                "<br>Coach name: " + coachName +
                "<br>Team name: " + teamName;
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 15k!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day!!!";
    }

    @GetMapping("/test")
    public String getTest() {
        return "OOps!";
    }

}
