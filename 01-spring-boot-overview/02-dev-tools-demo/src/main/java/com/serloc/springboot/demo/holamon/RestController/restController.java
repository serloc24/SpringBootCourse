package com.serloc.springboot.demo.holamon.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {

    @GetMapping("/")
    public String sayHello(){
        return "<h1>Hello World!</h1>";
    }

    //expose new endpoint

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 10k";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day";
    }
}
