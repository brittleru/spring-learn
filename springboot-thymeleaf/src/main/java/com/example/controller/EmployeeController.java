package com.example.controller;

import com.example.entity.employee.Employee;
import com.example.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

//    // load employee data
//    private List<Employee> employees;
//
//    @PostConstruct
//    private void loadData() {
//
//        // create employees
//        Employee employee1 = new Employee(1, "Diana", "Stoica", "diana@gmail.com");
//        Employee employee2 = new Employee(2, "Ana-Maria Luisa", "Mogoase", "luisa@gmail.com");
//        Employee employee3 = new Employee(3, "Sebastian", "Mocanu", "sebastian@gmail.com");
//        Employee employee4 = new Employee(4, "Catalin", "Picior", "catalin@gmail.com");
//
//        // create the list
//        employees = new ArrayList<>();
//
//        // add to the list
//        employees.add(employee1);
//        employees.add(employee2);
//        employees.add(employee3);
//        employees.add(employee4);
//
//    }

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // add mapping for "/list
    @GetMapping("/list")
    public String listEmployees(Model model) {

        // get the employees from the database
        List<Employee> employees = employeeService.findAll();

        // add to the spring models
        model.addAttribute("employees", employees);

        return "/employees/list-employees";
    }


    @GetMapping("/show-form")
    public String showForm(Model model) {

        // create model attribute to bind form data
        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "/employees/employee-form";
    }

    @GetMapping("/show-form-update")
    public String showFormUpdate(@RequestParam("employeeId") int id, Model model) {

        // get the employee from the service
        Employee employee = employeeService.findById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);

        // send over to our form
        return "/employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        // save the employee
        employeeService.save(employee);

        //use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {

        // delete the employee
        employeeService.deleteById(id);

        // redirect to /employees/list
        return "redirect:/employees/list";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam("employeeName") String name, Model model) {
        // search for the employee
        List<Employee> employees = employeeService.searchBy(name);

        // add to the spring model
        model.addAttribute("employees", employees);

        // send to /employees/list
        return "/employees/list-employees";
    }

}

















