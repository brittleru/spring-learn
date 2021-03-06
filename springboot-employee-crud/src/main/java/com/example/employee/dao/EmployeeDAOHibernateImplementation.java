//package com.example.employee.dao;
//
//import com.example.employee.entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//@Repository
//public class EmployeeDAOHibernateImplementation implements EmployeeDAO {
//
//    // define field for EntityManager
//    private EntityManager entityManager;
//
//    // setup constructor injection
//    @Autowired
//    public EmployeeDAOHibernateImplementation(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//
//    @Override
//    public List<Employee> findAll() {
//
//        // get the current hibernate session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        // create a query
//        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
//
//        // execute the query and get result list
//        List<Employee> employees = query.getResultList();
//
//        // return the results
//        return employees;
//    }
//
//    @Override
//    public Employee findById(int id) {
//
//        // get the current hibernate session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        // get the employee
//        Employee employee = currentSession.get(Employee.class, id);
//
//        // return the employee
//        return employee;
//    }
//
//    @Override
//    public void save(Employee employee) {
//
//        // get the current hibernate session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        // save the employee, if id=0 save/insert else update
//        currentSession.saveOrUpdate(employee);
//    }
//
//    @Override
//    public void deleteById(int id) {
//
//        // get the current hibernate session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        // delete object with primary key
//        Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
//        query.setParameter("employeeId", id);
//
//        query.executeUpdate();
//    }
//
//
//}
