package com.example.app.create;

import com.example.entities.Instructor;
import com.example.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Create {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")   // name of file optional
                                                    .addAnnotatedClass(Instructor.class)
                                                    .addAnnotatedClass(InstructorDetail.class)
                                                    .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {
            // create the objects
            Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
            InstructorDetail instructorDetail = new InstructorDetail(
                    "http://www.luv2code.com/youtube",
                    "Luv 2 code!!!");

            Instructor instructor1 = new Instructor("Diana", "Stoica", "diana@endava.com");
            InstructorDetail instructorDetail1 = new InstructorDetail(
                    "http://www.endava.com/youtube",
                    "Fishing");

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);
            instructor1.setInstructorDetail(instructorDetail1);

            // start a transaction
            session.beginTransaction();

            // save the instructor
            // Note: this will ALSO save the details object because of CascadeType.ALL
            System.out.println("Saving instructor: " + instructor);
            System.out.println("Saving instructor: " + instructor1);
            session.save(instructor);
            session.save(instructor1);


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
