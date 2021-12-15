package com.example.models;

import com.example.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {

    private String firstName;

    // if the validation fails for this field the message in ""  will display
    @NotNull(message="Field required")
    @Size(min=1, message="Field required")
    private String lastName;

    @NotNull(message = "Field required")
    @Min(value = 0, message = "Field must be greater than or equal to 0")
    @Max(value = 10, message = "Field must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{6}", message = "Only 6 chars/digits")
    private String postalCode;

    @CourseCode(value = "MED", message = "Must start with MEDzzzz!")
    private String courseCode;

    public Customer() {

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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
