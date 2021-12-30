package com.example.rest;

import com.example.entity.Student;
import com.example.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // define @PostConstruct to load the student data... only once!
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();

        students.add(new Student("Ana-Maria Luisa", "Mogoase"));
        students.add(new Student("Sebastian", "Mocanu"));
        students.add(new Student("Catalin", "Picior"));
    }


    // define endpoint for "/students" - return all the students with a get request
    // using jackson project in the background to transform the pojo object into json
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // define endpoint for "/students/{studentId}" - return student at index of studentId (must match)
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // just index into the list... keep it simple for now
//        return students.get(studentId);

        // check the studentId against the list size
        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }



}
