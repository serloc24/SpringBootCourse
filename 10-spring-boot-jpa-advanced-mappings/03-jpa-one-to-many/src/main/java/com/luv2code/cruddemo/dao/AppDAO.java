package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import java.util.Currency;
import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailsById(int theId);
    List<Course> findCoursesByInstructorId(int theId);
    Instructor findInstructorWithCoursesFetch(int theId);
    void update(Instructor theInstructor);
    void update(Course theCourse);
    Course findCourseById(int theId);
    void deleteCourseById(int theId);


}
