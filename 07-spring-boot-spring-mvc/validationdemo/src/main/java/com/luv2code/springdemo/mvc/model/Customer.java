package com.luv2code.springdemo.mvc.model;

import com.luv2code.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message = "is Required")
    @Size(min=1, message="is Required")
    private String lastName;

    @NotNull(message = "Is required")
    @Min(value=0, message = "It has to be greater than or equals to zero")
    @Max(value=10,message = "Must be less or equeals to ten")
    private Integer freePasses;

    @Pattern(regexp="^[a-zA-Z0-9]{5}", message =" only 5 chars/digits")
    private String postalCode;

    @CourseCode(value= "TOPS", message = "must start with TOPS")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }
}
