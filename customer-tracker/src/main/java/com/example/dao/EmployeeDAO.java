package com.example.dao;

import com.example.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getEmployees(int sortedValue);

    public void saveEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    public void deleteEmployeeById(int id);

    public List<Employee> searchEmployees(String searchName);
}
