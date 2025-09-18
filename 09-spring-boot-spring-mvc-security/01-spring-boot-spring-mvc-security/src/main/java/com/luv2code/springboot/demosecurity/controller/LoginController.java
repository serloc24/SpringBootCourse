package com.luv2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "fancy-login";
    }

    //add request maping for acces-denied
    @GetMapping("/acces-denied")
    public String showAccessDenied(){
        return "access-denied";
    }
}
