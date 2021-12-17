package com.example.app.read;

import com.example.entities.Course;
import com.example.entities.Instructor;
import com.example.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinEagerLazy {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")   // name of file optional
                                                    .addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(InstructorDetail.class)
                                                    .addAnnotatedClass(Course.class)
                                                    .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // option 2: Hibernate query with HQL

            // get the instructor from database
            int id = 1;

            Query<Instructor> query =
                    session.createQuery("select i from Instructor i " +
                            "JOIN FETCH i.courses " +
                            "where i.id=:instructorID",
                    Instructor.class);

            // set parameter on query
            query.setParameter("instructorID", id);

            // execute query and get instructor
            Instructor instructor = query.getSingleResult();

            System.out.println("luv2code: Instructor: " + instructor);



            // commit transaction
            session.getTransaction().commit();

            // close the session
            session.close();

            System.out.println("\nluv2code: The session is now closed!\n");
            
            // science the course are lazy loaded... this should fail


            // get course for the instructor
            System.out.println("luv2code: Courses: " + instructor.getCourses());


            System.out.println("luv2code: Done!");

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
