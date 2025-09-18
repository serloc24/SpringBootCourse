package com.luv2code.springdemo.mvc.Controller;

import com.luv2code.springdemo.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String showForm(Model theModel){
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    //Add an Init Binder to trim possible white spaces input
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult){
        System.out.println("Last name: | " + theCustomer.getLastName());
        System.out.println("Binding results: " + theBindingResult.toString());
        System.out.println("\n\n\n");
        if(theBindingResult.hasErrors()){
            return "customer-form";
        }
        return "customer-confirmation";

    }
}
