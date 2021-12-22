package com.example.controller;

import com.example.entity.Customer;
import com.example.service.EnterpriseService;
import com.example.utils.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

//    // need to inject the customer DAO into this controller
//    @Autowired
//    private CustomerDAO customerDAO;

    // instead of using DAO directly use the new layer Service
    // need to inject our customer service
    @Autowired
    private EnterpriseService enterpriseService;

//    @PostMapping("/list") // only want to handle POST request instead of all requests with @RequestMapping
    @GetMapping("/list") // only want to handle GET request instead of all requests with @RequestMapping
    public String listCustomers(Model model, @RequestParam(required = false, name = "sort") String sort) {

        // get customers from the DAO
//        List<Customer> customers = customerDAO.getCustomers();

        // get customers from the Service
//        List<Customer> customers = enterpriseService.getCustomers();

        // get customers form the service
        List<Customer> customers = null;

        if (sort != null) {
            int sortNumber = Integer.parseInt(sort);
            customers = enterpriseService.getCustomers(sortNumber);
        }
        else {
            // no sort field is provided, by default we sort by last name
            customers = enterpriseService.getCustomers(SortUtils.LAST_NAME);
        }

        // add the customers list to the model using "customers" for the jsp page
        model.addAttribute("customers", customers);

        return "list-customers";
    }


    // create the mapping for the customer form
    @GetMapping("/add")
    public String addCustomer(Model model) {

        // create a new model attribute to bind the form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "customer-form";
    }

    // create the mapping to save the data into the database (the strings are from the jsp form. action and modelAtr)
    @PostMapping("/save-customer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

        // save the customer using our service
        enterpriseService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    // update
    @GetMapping("/update")
    public String updateCustomer(@RequestParam("customerId") int id, Model model) {

        // get the customer from the service
        Customer customer = enterpriseService.getCustomerById(id);

        // set customer as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);

        // send over to our form
        return "customer-form";
    }


    // delete
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id) {

        // delete the customer
        enterpriseService.deleteCustomerById(id);

        return "redirect:/customer/list";
    }


    // search functionality
    @GetMapping("/search")
    public String searchCustomers(@RequestParam("searchCustomerName") String searchName, Model model) {
        List<Customer> customers = enterpriseService.searchCustomers(searchName);

        // add the customers to the model
        model.addAttribute("customers", customers);

        return "list-customers";
    }


}
