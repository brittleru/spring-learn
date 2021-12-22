package com.example.dao;

import com.example.entity.Customer;
import com.example.entity.Employee;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers(int sortedValue);

    public void saveCustomer(Customer customer);

    public Customer getCustomerById(int id);

    public void deleteCustomerById(int id);

    public List<Customer> searchCustomers(String searchName);

}
