package com.example.app.delete;

import com.example.entities.Instructor;
import com.example.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {

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

            // get instructor by primary key / id
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            System.out.println("Found instructor: " + instructor);
            // delete the instructors
            if (instructor != null) {
                System.out.println("Deleting: " + instructor);

                // Node: this will ALSO delete associated "details" object
                // because of CascadeType.ALL
                session.delete(instructor);
            }

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
