package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // add @Before advice
    @Before("com.example.aspect.utility.UtilityExpressions.forAppFlow()")
    public void before(JoinPoint joinPoint) {

        // display the method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("----> in @Before calling method: " + method);

        // display the arguments to the method

        // get the arguments
        Object[] args = joinPoint.getArgs();

        // loop through and display those args
        for (Object arg : args) {
            logger.info("====> argument: " + arg);
        }
    }

    // add @AfterReturning advice
    @AfterReturning(
            pointcut = "com.example.aspect.utility.UtilityExpressions.forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {

        // display the method we are returning from
        String method = joinPoint.getSignature().toShortString();
        logger.info("----> in @AfterReturning from method: " + method);

        // display the data returned from the data
        logger.info("====> result: " + result);

    }


}
