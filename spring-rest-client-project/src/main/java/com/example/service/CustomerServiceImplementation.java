package com.example.service;

import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private RestTemplate restTemplate;

    private String crmRestUrl;

    // sorry for hardcoding just for testing and learning purpose
//    private final String authStr = "susan:test123";
//    private final String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
    private final String adminUser = "susan";
    private final String adminPass = "test123";

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    public CustomerServiceImplementation(RestTemplate restTemplate, @Value("${crm.rest.url}") String url) {
        this.restTemplate = restTemplate;
        this.crmRestUrl = url;
        logger.info("Loaded property: crm.rest.url -> " + crmRestUrl);
    }

    @Override
    public List<Customer> getCustomers() {
        logger.info("in getCustomers(): Calling REST API " + crmRestUrl);

        // set auth for the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(adminUser, adminPass);
        HttpEntity<String> request = new HttpEntity<>(headers);

        // make REST call
        ResponseEntity<List<Customer>> responseEntity =
                restTemplate.exchange(
                        crmRestUrl,
                        HttpMethod.GET,
                        request, // additional request headers or body
                        new ParameterizedTypeReference<List<Customer>>() {
                            // this parameter means the type of the return value, the REST API return a JSON object
                            // in the background Spring uses Jackson to convert the JSON data to a list of Customer
                            // objects with the type of List<Customer>
        });


        // get the list of customers from response
        List<Customer> customers = responseEntity.getBody();

        logger.info("in getCustomers(): customers -->" + customers);
        logger.info("\n\nHEADERS -->" + responseEntity.getHeaders() + "\n\n");

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        logger.info("in saveCustomer(): Calling REST API " + crmRestUrl);

        // set auth for the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(adminUser, adminPass);

        // set body for the request
        Map<String, Object> body = new HashMap<>();
        body.put("id", customer.getId());
        body.put("firstName", customer.getFirstName());
        body.put("lastName", customer.getLastName());
        body.put("email", customer.getEmail());


        logger.info("\n\n\n" + headers + "\n\n\n");
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        int customerId = customer.getId();
        String addOrUpdate = null;

        // make the REST call
        if (customerId == 0) {
            // add customer this method sends an HTTP POST to the URL
            // first param: URL
            // second param: request - object to be POSTed
            // third param: responseType - the type of the response
            restTemplate.postForEntity(crmRestUrl, request, String.class);
            addOrUpdate = "added";
        }
        else {
            // update customer, this method sends an HTTP PUT to the URL
            // first param: URL
            // second param: the request - object to be PUTed
            restTemplate.put(crmRestUrl, request);
            addOrUpdate = "updated";
        }

        logger.info("in saveCustomer(): successfully " + addOrUpdate + " the customer = " + customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        logger.info("in getCustomerById(): Calling REST API " + crmRestUrl);

        // set auth for the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(adminUser, adminPass);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

//        // make the REST API call, this method makes an HTTP GET request for the URL
//        // first parameter: URL
//        // second parameter: the type of the return value
//        Customer customer = restTemplate.getForObject(crmRestUrl + "/" + id, Customer.class);

        // because the getForObject() method does not support setting headers we must use the exchange() method
        ResponseEntity<Customer> responseEntity = restTemplate.exchange(
                crmRestUrl + "/" + id,
                HttpMethod.GET,
                requestEntity,
                Customer.class,
                new ParameterizedTypeReference<Customer>() {
                    // this parameter means the type of the return value, the REST API return a JSON object
                    // in the background Spring uses Jackson to convert the JSON data to a list of Customer
                    // objects with the type of List<Customer>
                }
        );

        Customer customer = responseEntity.getBody();

        logger.info("in saveCustomer(): customer = " + customer);

        return customer;
    }

    @Override
    public void deleteCustomerById(int id) {
        logger.info("in deleteCustomerById(): Calling REST API " + crmRestUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(adminUser, adminPass);

        HttpEntity<?> requestEntity = new HttpEntity<Object>(headers);


        // make the REST API call, this method makes an HTTP DELETE request for the URL
        // first param: URL
//        restTemplate.delete(crmRestUrl + "/" + id);

        // again for security we can't use the .delete() method because it doesn't have any headers
        restTemplate.exchange(
                crmRestUrl + "/" + id,
                HttpMethod.DELETE,
                requestEntity,
                String.class
        );

        logger.info("in deleteCustomerById(): deleted customer with the id = " + id);
    }
}
