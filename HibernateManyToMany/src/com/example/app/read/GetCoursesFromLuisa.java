package com.example.app.read;

import com.example.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesFromLuisa {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")   // name of file optional
                                                    .addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(InstructorDetail.class)
                                                    .addAnnotatedClass(Course.class)
                                                    .addAnnotatedClass(Review.class)
                                                    .addAnnotatedClass(Student.class)
                                                    .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the student luisa from the database
            int luisaId = 2;
            Student luisa = session.get(Student.class, luisaId);
            System.out.println("\nLoaded student: " + luisa);
            System.out.println("Courses: " + luisa.getCourses());



            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // add clean-up code
            session.close();
            factory.close();
        }

    }

}
