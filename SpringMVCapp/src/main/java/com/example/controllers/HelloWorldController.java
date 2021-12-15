package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    // need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // a new controller method to read the form data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        // read the request parameter from the HTML form
        String name = request.getParameter("studentName");

        // convert the data to all uppercase
        name = name.toUpperCase();

        // create the message
        String result = "YO! " + name;

        // add the message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    // a new controller method to read the form data and add data to the model
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {

        // convert the data to all uppercase
        // create the message
        String result = "Hey My Friend from v3! " + name.toUpperCase();

        // add the message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

}
