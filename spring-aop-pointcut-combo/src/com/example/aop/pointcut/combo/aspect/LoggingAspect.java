package com.example.aop.pointcut.combo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.aop.pointcut.combo.dao.*.*(..))")
    private void forDaoPackage() {}

    // create point cut for getter methods
    @Pointcut("execution(* com.example.aop.pointcut.combo.dao.*.get*(..))")
    private void getter() {}

    // create pointcut for setter methods
    @Pointcut("execution(* com.example.aop.pointcut.combo.dao.*.set*(..))")
    private void setter() {}

    // create point: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterOrSetter() {}



    @Before("forDaoPackageNoGetterOrSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n\t-> Executing @Before advice on method()");
    }

    @Before("forDaoPackageNoGetterOrSetter()")
    public void performApiAnalytics() {
        System.out.println("\n\t-> Performing API analytics");
    }



}


















