package com.example.controller;

import com.example.entity.Customer;
import com.example.entity.Employee;
import com.example.service.EnterpriseService;
import com.example.utils.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EnterpriseService enterpriseService;

    @RequestMapping("/list")
    public String getEmployeeData(Model model, @RequestParam(required = false, name = "sort") String sort) {

        // employees
//        List<Employee> employees = enterpriseService.getEmployees();
        List<Employee> employees = null;
        if (sort != null) {
            int sortNumber = Integer.parseInt(sort);
            employees = enterpriseService.getEmployees(sortNumber);
        }
        else {
            // no sort field is provided, by default we sort by last name
            employees = enterpriseService.getEmployees(SortUtils.LAST_NAME);
        }


        model.addAttribute("employees", employees);

        return "list-employees";
    }

    // create the mapping for the customer form
    @GetMapping("/add")
    public String addEmployee(Model model) {

        // create a new model attribute to bind the form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-form";
    }

    // create the mapping to save the data into the database (the strings are from the jsp form. action and modelAtr)
    @PostMapping("/save-employee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        // save the customer using our service
        enterpriseService.saveEmployee(employee);

        return "redirect:/employee/list";
    }

    // update
    @GetMapping("/update")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model) {

        // get the customer from the service
        Employee employee = enterpriseService.getEmployeeById(id);

        // set customer as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);

        // send over to our form
        return "employee-form";
    }

    // delete
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id) {

        // delete the customer
        enterpriseService.deleteEmployeeById(id);

        return "redirect:/employee/list";
    }

    // search functionality
    @GetMapping("/search")
    public String searchmployee(@RequestParam("searchEmployeeName") String searchName, Model model) {
        List<Employee> employees = enterpriseService.searchEmployees(searchName);

        // add the customers to the model
        model.addAttribute("employees", employees);

        return "list-employees";
    }
}
