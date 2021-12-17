package com.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    // define our fields

    // define constructors

    // define getter setter

    // define toString

    // annotate fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                            CascadeType.DETACH, CascadeType.REFRESH})  // we don't want to cascade.Delete for instructor
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // if we delete course we want to delete reviews
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.LAZY,  // we don't want to get all the students at once
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})  // we don't want to cascade.Delete for students
    @JoinTable(
            name = "course_student",                              // table created in DB
            joinColumns = @JoinColumn(name = "course_id"),        // reference to the course (this class)
            inverseJoinColumns = @JoinColumn(name = "student_id") // actual student from the other-side  (the other class)
    )
    private List<Student> students;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // add a convenience method for adding reviews for the course
    public void addReview(Review review) {
        if (reviews == null) {
            reviews = new ArrayList<>();
        }

        reviews.add(review);
    }

    // add a convenience method for adding students to the course
    public void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }

        students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
