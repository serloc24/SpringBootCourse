package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    //Show the form
    @RequestMapping("/showStudentForm")
    public String showForm(Model theModel){
        //Create a student object
        Student theStudent = new Student();

        //Add the student as model attribute
        theModel.addAttribute("student", theStudent);

        //add the list of countries to the model
        theModel.addAttribute("countries", countries);

        //add the list of languages to the model
        theModel.addAttribute("languages", languages);

        //add the systems list to the model
        theModel.addAttribute("systems", systems);

        return "student-form";
    }

    @PostMapping("processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent){
        System.out.println("Student saved with name: " + theStudent.getFirstName() +" and last name " + theStudent.getLastName()
        + " with country: " + theStudent.getCountry());
        return "student-confirmation";
    }

}
