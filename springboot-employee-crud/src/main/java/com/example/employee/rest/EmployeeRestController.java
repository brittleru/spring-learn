//package com.example.employee.rest;
//
////import com.example.employee.dao.EmployeeDAO;
//import com.example.employee.entity.Employee;
//import com.example.employee.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api")
//public class EmployeeRestController {
//
//    private EmployeeService employeeService;
//
//    @Autowired
//    public EmployeeRestController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//
//
//    // expose "/employees" endpoint that will return a list of all employees
//    @GetMapping("/employees")
//    public List<Employee> findAll() {
//        return employeeService.findAll();
//    }
//
//    // add mapping for GET /employees/{employeeId}
//    @GetMapping("/employees/{employeeId}")
//    public Employee getEmployee(@PathVariable int employeeId) {
//        Employee employee = employeeService.findById(employeeId);
//
//        if (employee == null) {
//            throw new RuntimeException("Employee id not found - " + employeeId);
//        }
//
//        return employee;
//    }
//
//    // add mapping for POST /employees - add new employee
//    @PostMapping("/employees")
//    public Employee addEmployee(@RequestBody Employee employee) {
//
//        // also JST in case they pass an id in the JSON object, set id to 0
//        // this is to force a save of a new item... instead of an update
//        employee.setId(0);
//
//        employeeService.save(employee);
//
//        return employee;
//    }
//
//
//    // add mapping for PUT /employees - update existing employee
//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee employee) {
//
//        employeeService.save(employee);
//
//        return employee;
//    }
//
//
//    // add mapping for DELETE /employees/{employeeId} - delete employee
//    @DeleteMapping("/employees/{employeeId}")
//    public String deleteEmployee(@PathVariable int employeeId) {
//
//        Employee employee = employeeService.findById(employeeId);
//
//        // throw exception if null
//        if (employee == null) {
//            throw new RuntimeException("Employee id not found - " + employeeId);
//        }
//
//        employeeService.deleteById(employeeId);
//
//        return "Deleted employee id - " + employeeId;
//    }
//
//
//
//
//
//
//
//
//
//
//}
