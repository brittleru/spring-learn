package com.example.aop.after.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UtilityExpressions {

    @Pointcut("execution(* com.example.aop.after.dao.*.*(..))")
    protected void forDaoPackage() {}

    // create point cut for getter methods
    @Pointcut("execution(* com.example.aop.after.dao.*.get*(..))")
    protected void getter() {}

    // create pointcut for setter methods
    @Pointcut("execution(* com.example.aop.after.dao.*.set*(..))")
    protected void setter() {}

    // create point: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    protected void forDaoPackageNoGetterOrSetter() {}

}
