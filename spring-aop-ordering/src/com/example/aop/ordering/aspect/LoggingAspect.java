package com.example.aop.ordering.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect  {

    @Before("com.example.aop.ordering.aspect.UtilityExpressions.forDaoPackageNoGetterOrSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n\t-> Executing @Before advice on method()");
    }

}


















