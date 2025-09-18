package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(4)
public class MyDemoLoggingAspect {
    //@Before(value = "execution(void add*())")
    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.packageNoGetterNoSetter() ")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){

        System.out.println("=== This is executing @Before the method");

        //Display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        //Display the method arguments
        Object[] args = joinPoint.getArgs();
        for (Object o : args){
            System.out.println("Object: " + o.toString());
        }

    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
            returning = "result"
    )
    public void afterReturningFindAccount(JoinPoint theJoinPoint, List<Account> result){
        //Print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("=====> @AfterReturning on method " + method);

        //Print on the result
        System.out.println("Before we modify the data: \n " + result);
        if(!result.isEmpty()) convertAccountNamesToUpperCase(result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account c : result){
            c.setName(c.getName().toUpperCase());
            c.setLevel(c.getLevel().toUpperCase());
        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAdvice(JoinPoint theJoinPoint, Throwable theExc){

        //Print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("===> @AfterThrowing on method " + method);

        //log the exception
        System.out.println("===> The exception is: " + theExc );


    }

}
