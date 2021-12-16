package com.example.app;

import com.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyGenerator {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")   // name of file optional
                                                    .addAnnotatedClass(Student.class)
                                                    .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {

            // create 3 student objects
            System.out.println("Creating 3 student objects...");
            Student tempStudent1 = new Student("Ana-Maria Luisa", "Mogoase", "luisa@endava.com");
            Student tempStudent2 = new Student("Sebastian", "Mocanu", "sebastian@endava.com");
            Student tempStudent3 = new Student("Catalin", "Picior", "catalin@endava.com");

            // start a transaction
            session.beginTransaction();

            // save the student object (the world)
            System.out.println("Saving the students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

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
