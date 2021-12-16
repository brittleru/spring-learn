package com.example.app;

import com.example.entity.Employee;
import com.example.utils.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.swing.*;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class Main {

    private static SessionFactory factory;
    private static Session session;

    public static void main(String[] args) {

        factory = new Configuration().configure("hibernate.cfg.xml")   // name of file optional
                                     .addAnnotatedClass(Employee.class)
                                     .buildSessionFactory();
//        session = factory.getCurrentSession();

        try {
            // uncomment this to populate the database
            generatingEmployees();
            Employee test = getEmployeeById(2);
            List<Employee> testList = getEmployeesByCompany("Endava");
            List<Employee> testList2 = getEmployeesByCompany("Ericcson");

            System.out.println("\n\nGot employee -> " + test);
            System.out.println("\n\nGot employees from Endava -> " + testList);
            System.out.println("\n\nGot employees from Ericcson -> " + testList2);

            deleteEmployeeById(8);
//            System.out.println("Trying to retrieve the employee with id=4");
//            Employee test2 = getEmployeeById(4);


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            factory.close();
        }

    }


    // create, get by id, get by company, delete by id
    private static Employee getEmployeeById(int id) {
        Employee wantedEmployee;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Extracting employee with id=" + id);
            Query<Employee> query = session.createQuery("from Employee e where e.id= :given_id", Employee.class);
            query.setParameter("given_id", id);
            wantedEmployee = query.getSingleResult();
            System.out.println(wantedEmployee);

            session.getTransaction().commit();
            return wantedEmployee;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Employee doesn't exist in the database");
        return null;
    }

    private static List<Employee> getEmployeesByCompany(String company) {
        List<Employee> wantedEmployees;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Extracting employees from company: " + company);
            Query<Employee> query = session.createQuery("from Employee e where e.company= :given_company", Employee.class);
            query.setParameter("given_company", company);
            wantedEmployees = query.getResultList();
            System.out.println(wantedEmployees);

            session.getTransaction().commit();
            return wantedEmployees;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("There are no employees from " + company);
        return null;
    }

    private static void deleteEmployeeById(int id) {
        try {
            System.out.println("Selecting employee with details: ");
//            Employee employee = session.get(Employee.class, id);
            Employee employee = getEmployeeById(id);

            System.out.println("Deleting employee with id=" + id);
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.delete(employee);
//            Query<Employee> query = session.createQuery("delete from Employee where id= :given_id", Employee.class);
//            query.setParameter("given_id", id);
//            query.executeUpdate();

            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createEmployee(String firstName, String lastName, String company, Date dateOfBirth) {
        try {
            session = factory.getCurrentSession();

            System.out.println("Create a new employee...");
            Employee employee = new Employee(firstName, lastName, company, dateOfBirth);
            session.beginTransaction();

            System.out.println("Saving the employee into the database:\n" + employee);
            session.save(employee);
            session.getTransaction().commit();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void generatingEmployees() throws ParseException {
        createEmployee("Diana", "Stoica", "Endava", DateUtils.parseDate("16/12/1996"));
        createEmployee("Ana-Maria Luisa", "Mogoase", "Endava", DateUtils.parseDate("04/05/1998"));
        createEmployee("Sebastian", "Mocanu", "Endava", DateUtils.parseDate("27/03/1998"));
        createEmployee("Catalin", "Picior", "Endava", DateUtils.parseDate("20/02/2000"));
        createEmployee("Andrei", "Cojocaru", "Ericcson", DateUtils.parseDate("04/06/1998"));
    }

}
