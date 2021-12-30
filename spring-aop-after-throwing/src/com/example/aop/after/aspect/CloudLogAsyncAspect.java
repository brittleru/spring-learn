package com.example.aop.after.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAsyncAspect {

    @Before("com.example.aop.after.aspect.UtilityExpressions.forDaoPackageNoGetterOrSetter()")
    public void logToCloudAsync() {
        System.out.println("\n\t-> Logging to Cloud in async fashion");
    }

}
