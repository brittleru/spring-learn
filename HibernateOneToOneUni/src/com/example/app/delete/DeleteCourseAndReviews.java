package com.example.app.delete;

import com.example.entities.Course;
import com.example.entities.Instructor;
import com.example.entities.InstructorDetail;
import com.example.entities.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviews {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")   // name of file optional
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the course
            int id = 10;  // check your id in database sorry hardcoded >.<
            Course course = session.get(Course.class, id);

            // print the course
            System.out.println("Deleting the course ...");
            System.out.println(course);

            // print the course reviews
            System.out.println(course.getReviews());

            // delete the course
            session.delete(course);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // add clean-up code
            session.close();
            factory.close();
        }

    }

}
