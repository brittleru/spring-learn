package com.example.controllers;

import com.example.models.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // add an initbinder ... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation
    // it will be called to every web request for our controller
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // iff all space trim it all to null
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

        System.out.println("Last name: |" + customer.getLastName() + "|");
        System.out.println("First name: |" + customer.getFirstName() + "|");

        System.out.println("Binding result: " + bindingResult);
        System.out.println("\n\n\n\n");


        if (bindingResult.hasErrors()) {
            return "customer-form";
        }
        return "customer-confirmation";
    }


}
