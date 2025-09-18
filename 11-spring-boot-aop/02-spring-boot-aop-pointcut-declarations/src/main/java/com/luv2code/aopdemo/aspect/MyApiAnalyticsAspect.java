package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class MyApiAnalyticsAspect {

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.packageNoGetterNoSetter()")
    public void performApiAnalytics(){
        System.out.println("=== THIS IS NOT A GETTER OR A SETTER ===");
    }
    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune())")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
        System.out.println("Executing @Around method");
        long begin = System.currentTimeMillis();

        Object result = theProceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println("The method getFortune() duration is: " + duration + "milliseconds");
        return result;
    }
}
