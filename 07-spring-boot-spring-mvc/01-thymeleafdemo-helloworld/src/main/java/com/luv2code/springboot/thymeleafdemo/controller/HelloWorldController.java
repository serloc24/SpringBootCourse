package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //New a controller method to show initial HTML
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //Controller method to process the HTML form
    @GetMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //Controller to read form data an add data to the model
    @PostMapping("/processFormVersionTwo")
    public String letsShoutDude(@RequestParam("studentName") String theName , Model model){
        //Read the request parameter from HTML form
        //Not needed because of @RequestParam annotation
        // String theName = request.getParameter("studentName");

        //Convert the data to all caps
        theName = theName.toUpperCase();

        //create the message
        String result = "YO!! " + theName;

        //add the message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
