package com.example.repositories;

import com.example.dao.CustomerDAO;
import com.example.entity.Customer;
import com.example.utils.SortUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImplementation implements CustomerDAO {

    // need to dependency inject the session factory see "spring-mvc-crud... .xml" file
    @Autowired
    @Qualifier("customerSessionFactory")
    private SessionFactory sessionFactory;

    @Transactional("customerTransactionManager")
    public List<Customer> getCustomers(int sortedValue) {

        // get the current hibernate session which was auto-wired (injected) for us
        Session currentSession = sessionFactory.getCurrentSession();

        String fieldName = null;

        switch (sortedValue) {
            case SortUtils.FIRST_NAME:
                fieldName = "firstName";
                break;
            case SortUtils.LAST_NAME:
                fieldName = "lastName";
                break;
            case SortUtils.EMAIL:
                fieldName = "email";
                break;
            default:
                fieldName = "lastName";
                break;
        }

        // create a query
        String queryValue = "from Customer order by " + fieldName;
//        Query<Customer> query = currentSession.createQuery("from Customer order by :nameValue", Customer.class);
        Query<Customer> query = currentSession.createQuery(queryValue, Customer.class);
//        query.setParameter("nameValue", fieldName);
        // execute query and get result
        List<Customer> customers = query.getResultList();

        // return the results
        return customers;
    }

    @Transactional("customerTransactionManager")
    public void saveCustomer(Customer customer) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save or update the customer if it already exists into the database
        currentSession.saveOrUpdate(customer);
    }

    @Transactional("customerTransactionManager")
    public Customer getCustomerById(int id) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve / read from database using the primary key
        Customer customer = currentSession.get(Customer.class, id);

        return customer;
    }

    @Transactional("customerTransactionManager")
    public void deleteCustomerById(int id) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query query = currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);

        query.executeUpdate();
    }

    @Transactional("customerTransactionManager")
    public List<Customer> searchCustomers(String searchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = null;

        // only search by name if the searchName is not empty
        if (searchName != null && searchName.trim().length() > 0) {
            // search for firstName or lastName case insensitive
            query = currentSession.createQuery("from Customer where lower(firstName) like :name or lower(lastName) like :name order by lastName", Customer.class);
            query.setParameter("name", "%" + searchName.toLowerCase() + "%");
        }
        else {
            // if the query is empty get all the customers
            query = currentSession.createQuery("from Customer order by lastName", Customer.class);
        }

        // execute query and get the result list
        List<Customer> customers = query.getResultList();

        // return the results
        return customers;
    }


}
