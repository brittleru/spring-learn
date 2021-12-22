package com.example.repositories;

import com.example.dao.EmployeeDAO;
import com.example.entity.Customer;
import com.example.entity.Employee;
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
public class EmployeeDAOImplementation implements EmployeeDAO {

    // need to inject the session factory
    @Autowired
    @Qualifier("employeeSessionFactory")
    private SessionFactory sessionFactory;

    @Transactional("employeeTransactionManager")
    public List<Employee> getEmployees(int sortedValue) {

        // get the current hibernate session
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
        String queryValue = "from Employee order by " + fieldName;
//        Query<Customer> query = currentSession.createQuery("from Customer order by :nameValue", Customer.class);
        Query<Employee> query = currentSession.createQuery(queryValue, Employee.class);
//        query.setParameter("nameValue", fieldName);
        // execute query and get result
        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Transactional("employeeTransactionManager")
    public void saveEmployee(Employee employee) {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save or update the employee if it already exists into the database
        currentSession.saveOrUpdate(employee);
    }

    @Transactional("employeeTransactionManager")
    public Employee getEmployeeById(int id) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve / read from database using the primary key
        Employee employee = currentSession.get(Employee.class, id);

        return employee;
    }

    @Transactional("employeeTransactionManager")
    public void deleteEmployeeById(int id) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);

        query.executeUpdate();
    }

    @Transactional("employeeTransactionManager")
    public List<Employee> searchEmployees(String searchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = null;

        // only search by name if the searchName is not empty
        if (searchName != null && searchName.trim().length() > 0) {
            // search for firstName or lastName case insensitive
            query = currentSession.createQuery("from Employee where lower(firstName) like :name or lower(lastName) like :name order by lastName", Employee.class);
            query.setParameter("name", "%" + searchName.toLowerCase() + "%");
        }
        else {
            // if the query is empty get all the customers
            query = currentSession.createQuery("from Employee order by lastName", Employee.class);
        }

        // execute query and get the result list
        List<Employee> employees = query.getResultList();

        // return the results
        return employees;
    }
}
