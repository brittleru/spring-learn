package com.example.controller;

import com.example.entity.Customer;
import com.example.entity.Employee;
import com.example.service.EnterpriseService;
import com.example.utils.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("/list")
    public String getData(Model model, @RequestParam(required = false, name = "sort") String sortValue) {

        // customers
        // get customers form the service
        List<Customer> customers = null;
        List<Employee> employees = null;

        if (sortValue != null) {
            int sortNumber = Integer.parseInt(sortValue);
            customers = enterpriseService.getCustomers(sortNumber);
            employees = enterpriseService.getEmployees(sortNumber);
        }
        else {
            // no sort field is provided, by default we sort by last name
            customers = enterpriseService.getCustomers(SortUtils.LAST_NAME);
            employees = enterpriseService.getEmployees(SortUtils.LAST_NAME);
        }

        // add the customers list to the model using "customers" for the jsp page
        model.addAttribute("customers", customers);

        // employees
        model.addAttribute("employees", employees);

        return "list-enterprise";
    }

}
