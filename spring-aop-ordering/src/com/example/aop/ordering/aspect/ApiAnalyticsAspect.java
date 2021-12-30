package com.example.aop.ordering.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {

    @Before("com.example.aop.ordering.aspect.UtilityExpressions.forDaoPackageNoGetterOrSetter()")
    public void performApiAnalytics() {
        System.out.println("\n\t-> Performing API analytics");
    }


}
