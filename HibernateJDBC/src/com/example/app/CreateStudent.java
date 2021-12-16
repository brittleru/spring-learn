package com.example.app;

import com.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class CreateStudent {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")   // name of file optional
                                                    .addAnnotatedClass(Student.class)
                                                    .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {
            // use the session to save Java object (j.k. use to save the world)
            // create a student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Paul", "Wall", "paul@endava.com");

            // start a transaction
            session.beginTransaction();

            // save the student object (the world)
            System.out.println("Saving the student...");
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            factory.close();
        }

    }

}
