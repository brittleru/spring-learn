package com.example.aop.pointcut.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.aop.pointcut.dao.*.*(..))")
    private void forDaoPackage() {}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n\t-> Executing @Before advice on method()");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n\t-> Performing API analytics");
    }



}


















