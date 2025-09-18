package com.serloc.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    CricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    //Define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("Im doing myStartupstuff() " + getClass().getSimpleName());
    }

    //Define our destroy method
    @PreDestroy
    public void doMyCleanup(){
        System.out.println("Im doing my Cleanupstuff() " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
