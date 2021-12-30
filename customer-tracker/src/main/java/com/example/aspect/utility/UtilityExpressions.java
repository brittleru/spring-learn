package com.example.aspect.utility;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UtilityExpressions {

    // setup pointcut declarations
    @Pointcut("execution(* com.example.controller.*.*(..))") // any class, any method and any number of args
    public void forControllerPackage() {}

    @Pointcut("execution(* com.example.service.*.*(..))") // any class, any method and any number of args
    public void forServicePackage() {}

    @Pointcut("execution(* com.example.dao.*.*(..))") // any class, any method and any number of args
    public void forDaoPackage() {}

    @Pointcut("execution(* com.example.repositories.*.*(..))") // any class, any method and any number of args
    public void forRepositoriesPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage() || forRepositoriesPackage()")
    public void forAppFlow() {}

}
