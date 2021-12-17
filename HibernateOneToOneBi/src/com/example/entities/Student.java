package com.example.entities;

import javax.persistence.*;

/**
 * We use JPA annotation instead of Hibernate as a good practice :))
 * JPA is a standard specification and Hibernate implements that JPA specification
 */
@Entity
@Table(name = "student")  // optional since it has the same name as the class
public class Student {

    // annotate the java fields to the database columns
    @Id                                                  // primary key annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // assign PK using db identity column
    @Column(name = "id")                                 // must be the same as in database
    private int id;                                      // can be any name

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    // must create default constructor because it will create an instance of my entity using the new keyword so it will
    // attempt to use "new Student()" behind the scenes by Hibernate and because I already have a constructor I must
    // define a new one with no arg similar cu dependency injection stuff
    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
