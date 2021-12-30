package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    // add request mapping for /leaders
    @GetMapping("/leaders")
    public String showLeaders() {
        return  "leaders";
    }

    // add request mapping for /systems
    @GetMapping("/systems")
    public String showSystems() {
        return "systems";
    }

}
