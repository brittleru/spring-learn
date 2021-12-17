package com.example.app.create;

import com.example.entities.Course;
import com.example.entities.Instructor;
import com.example.entities.InstructorDetail;
import com.example.entities.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviews {

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

            // create a course
            Course course = new Course("Pacman - How to Score One Millions Points");

            // add some reviews
            course.addReview(new Review("Great course... loved it!"));
            course.addReview(new Review("Cool course, job well done!"));
            course.addReview(new Review("What a dumb course, you are dumb-dumb!"));
            course.addReview(new Review("I love fat cats!"));
            course.addReview(new Review("Potatoes are cool :D"));

            // save the course ... and leverage the cascade all :-) =))))
            System.out.println("Saving the course");
            System.out.println(course);
            System.out.println(course.getReviews());
            session.save(course);


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
