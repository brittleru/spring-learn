package com.example.service;

import com.example.dao.CustomerDAO;
import com.example.dao.EmployeeDAO;
import com.example.entity.Customer;
import com.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnterpriseServiceImplementation implements EnterpriseService {

    // need to inject the customer DAO
    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

    public List<Customer> getCustomers(int sortedValue) {
        return customerDAO.getCustomers(sortedValue);
    }

    public List<Employee> getEmployees(int sortedValue) {
        return employeeDAO.getEmployees(sortedValue);
    }

    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }

    public void deleteCustomerById(int id) {
        customerDAO.deleteCustomerById(id);
    }

    public List<Customer> searchCustomers(String searchName) {
        return customerDAO.searchCustomers(searchName);
    }

    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    public void deleteEmployeeById(int id) {
        employeeDAO.deleteEmployeeById(id);
    }

    public List<Employee> searchEmployees(String searchName) {
        return employeeDAO.searchEmployees(searchName);
    }


}
