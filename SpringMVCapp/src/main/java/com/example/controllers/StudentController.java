package com.example.controllers;

import com.example.models.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @RequestMapping("/showForm")
    public String showForm(Model model) {

        // create a new student object
        Student student = new Student();

        // add that student object to the model attribute
        model.addAttribute("student", student);

        // add the country options from the file to the model (use the string in html)
        model.addAttribute("countryOptions", countryOptions);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {

        // log the input data
        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());

        return "student-confirmation";
    }
}
