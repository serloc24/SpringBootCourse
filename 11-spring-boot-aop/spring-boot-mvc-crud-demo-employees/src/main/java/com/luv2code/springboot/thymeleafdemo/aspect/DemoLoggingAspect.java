package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
    //Setup Logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //Setup pointcut declarations
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    //add @Before Advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
        //Display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("===> in @Before calling method: " + theMethod);

        //Display the arguments to the method
        Object[] args = theJoinPoint.getArgs();
        if(args != null){
            for(Object o : args) myLogger.info("This is an argument: " + o.toString());
        }

    }

    @AfterReturning(pointcut = "forAppFlow()",
                    returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("===> in @AfterReturning calling method: " + theMethod);

        myLogger.info("===> RESULT: " + theResult);
    }
}
