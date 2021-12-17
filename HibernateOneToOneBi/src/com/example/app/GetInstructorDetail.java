package com.example.app;

import com.example.entities.Instructor;
import com.example.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetail {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")   // name of file optional
                                                    .addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(InstructorDetail.class)
                                                    .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the instructor detail object
            int id = 33;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            // print the instructor detail
            System.out.println("Instructor Details: " + instructorDetail);

            // print the associated instructor
            System.out.println("Associated Instructor: " + instructorDetail.getInstructor());

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // handle connection leak issue with closing the session
            session.close();
            factory.close();
        }

    }

}
