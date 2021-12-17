package com.example.app.delete;

import com.example.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourse {

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

            // get the PacMan course  from the database
            int courseId = 10;
            Course pacman = session.get(Course.class, courseId);

            // delete the course
            System.out.println("Deleting course: " + pacman);
            session.delete(pacman);

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
