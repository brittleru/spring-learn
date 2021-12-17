package com.example.app.create;

import com.example.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudents {

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

            // create a course
            Course course = new Course("Pacman - How to Score One Millions Points");


            // save the course ... and leverage the cascade all :-) =))))
            System.out.println("\nSaving the course");
            session.save(course);
            System.out.println("Saved the course: " + course);

            // create the students
            Student student1 = new Student("Ana-Maria Luisa", "Mogoase", "luisa@endava.com");
            Student student2 = new Student("Sebastian", "Mocanu", "sebastian@endava.com");
            Student student3 = new Student("Catalin", "Picior", "catalin@endava.com");

            // add students to the course
            course.addStudent(student1);
            course.addStudent(student2);
            course.addStudent(student3);

            // save the students
            System.out.println("\nSaving students...");
            session.save(student1);
            session.save(student2);
            session.save(student3);
            System.out.println("Saved students: " + course.getStudents());

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
