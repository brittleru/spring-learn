package com.example.app;

import com.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class QueryStudent {

    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")   // name of file optional
                                                    .addAnnotatedClass(Student.class)
                                                    .buildSessionFactory();

        // create a session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // query students
            List<Student> students = session.createQuery("from Student", Student.class).getResultList();

            // display the students
            System.out.println("\nDisplaying all students...");
            displayStudents(students);

            // query students: lastName="Doe" need to use java prop name not from Database

            // NOT SAFE WAY
            // students = session.createQuery("from Student s where s.lastName='Mogoase'", Student.class).getResultList();

            // GOOD WAY, TO AVOID SQL INJECTION
            Query<Student> query = session.createQuery("from Student s where s.lastName= :name", Student.class);
            query.setParameter("name", "Mogoase");
            students = query.getResultList();

            // display the students
            System.out.println("\nStudents who have last name of Mogoase");
            displayStudents(students);

            // ===============================================================

            // query students: lastName='Doe' OR firstName="Daffy" unsafe way
//            students = session
//                    .createQuery("from Student s where s.lastName='Mogoase' OR s.firstName='Sebastian'", Student.class)
//                    .getResultList();

            // again safe way
            Query<Student> query1 = session
                    .createQuery("from Student s where s.lastName= :name1 OR s.firstName= :name2", Student.class);
            query1.setParameter("name1", "Mogoase");
            query1.setParameter("name2", "Sebastian");
            students = query1.getResultList();

            System.out.println("\n\nStudents who have last name of Doe OR first name Daffy");
            displayStudents(students);

            // =============================================================
            // query students where email LIKE "%endava.com"
            // bad way
            // students = session.createQuery("from Student s where s.email LIKE '%endava.com'", Student.class).getResultList();
            // good way
            Query<Student> query2 = session
                    .createQuery("from Student s where s.email LIKE :email1", Student.class);
            query2.setParameter("email1", "%endava.com");
            students = query2.getResultList();

            System.out.println("\n\nStudens whose email ends with endava.com");
            displayStudents(students);

            // TODO: este hibernate createQuery() o metoda sa se faca sql injection?

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

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
