package com.example.app.delete;

import com.example.entities.Instructor;
import com.example.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetail {

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
            int id = 4;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            // print the instructor detail
            System.out.println("Instructor Details: " + instructorDetail);

            // print the associated instructor
            System.out.println("Associated Instructor: " + instructorDetail.getInstructor());

            // now let's delete the instructor detail
            System.out.println("Deleting Instructor Detail: " + instructorDetail);

            // remove the associated object reference
            // break bi-directional link
            instructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(instructorDetail);


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
