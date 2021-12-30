package com.example.rest;

import com.example.entity.Customer;
import com.example.exception.CustomerNotFoundException;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    // auto-wire the CustomerService
    @Autowired
    private CustomerService customerService;

    // add mapping to retrieve all the current customers GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    // add mapping to get a customer by id GET /customers/{customerId}
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer = customerService.getCustomerById(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }

        return customer;
    }


    // mapping for POST /customers - add a new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {

        // also just in case pass an id in JSON and set it to 0
        // this will force a save of a new item in db instead of update
        customer.setId(0);

        customerService.saveCustomer(customer);

        return customer;
    }


    // add mapping for PUT /customers - update existing customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {

        customerService.saveCustomer(customer);

        return customer;
    }


    // add mapping for DELETE /customers/{customerId} - delete the customer by ID
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        Customer customer = customerService.getCustomerById(customerId);

        // check if customer is null and throw an exception
        if (customer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }

        customerService.deleteCustomerById(customerId);

        return "Deleted customer id - " + customerId;
    }


}
