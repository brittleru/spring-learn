package com.example.service;

import com.example.entity.Customer;
import com.example.entity.Employee;

import java.util.List;

public interface EnterpriseService {

    public List<Customer> getCustomers(int sortedValue);

    public List<Employee> getEmployees(int sortedValue);

    public void saveCustomer(Customer customer);

    public Customer getCustomerById(int id);

    public void deleteCustomerById(int id);

    public List<Customer> searchCustomers(String searchName);

    public void saveEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    public void deleteEmployeeById(int id);

    public List<Employee> searchEmployees(String searchName);
}
