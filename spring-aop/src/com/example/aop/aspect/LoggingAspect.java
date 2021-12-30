package com.example.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    // modifier? -> return-type -> declaring-type> -> method-name + parameters -> throws?
    // the thingies that have "?" are optional
    // declaring-type is the full class name com.bla.bla.bla.Class.Method
    // we can use * like add* meaning that any method that starts with add it will be selected
    // or we can use * for the return type and use it for any return type
    //    @Before("execution(public void updateAccount())") // pointcut expression for this method signature
    //    @Before("execution(public void addAccount ())") // get all addAccount() methods :D
//    @Before("execution(public void com.example.aop.dao.AccountDAO.addAccount())") // pointcut expression for this method signature
//    @Before("execution(public void add*())") // pointcut expression for this method signature
//    @Before("execution(void add*())") // pointcut expression for this method signature
//    @Before("execution(* add*())") // pointcut expression for this method signature
//    @Before("execution(* add*(com.example.aop.Account))") // pointcut expression for this method signature
//    @Before("execution(* add*(Account))") // need to use the fully qualified classname
//    @Before("execution(* add*(com.example.aop.Account, ..))") // need to use the fully qualified classname
    @Before("execution(* com.example.aop.dao.*.*(..))") // need to use the fully qualified classname
    public void beforeAddAccountAdvice() {

        System.out.println("\n\t-> Executing @Before advice on addAccount()");

    }




}


















