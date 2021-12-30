package com.example.aop.around.aspect;

import com.example.aop.around.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggingAspect  {
    
    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.example.aop.around.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // print out the method we are advising on
        // print out which method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n\t-----> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        }
        catch (Exception e) {
            // log the exception
                logger.warning(e.getMessage());

//            // give the user a custom message
//            result = "Major accident! But no worries, your private AOP helicopter is on the way!";
//
            // rethrow the exception
            throw e;
        }


        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        logger.info("\n\t ====> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.example.aop.around.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n\t-----> Executing @After (finally) on method: " + method);

        //

    }

    @AfterThrowing(
            pointcut = "execution(* com.example.aop.around.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n\t-----> Executing @AfterThrowing on method: " + method);

        // log the exception
        logger.info("\n\t-----> The exception is: " + exc);

    }


    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.example.aop.around.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        // print out witch method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n\t-----> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        logger.info("\n\t-----> Result is: " + result);

        // let's post-process the data ... let's modify it :-]

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        // print out the results of the method call
        logger.info("\n\t-----> Result is: " + result);
    }



    // join point gives us metadata about the methods we are calling
    @Before("com.example.aop.around.aspect.UtilityExpressions.forDaoPackageNoGetterOrSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        logger.info("\n\t-> Executing @Before advice on method()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        logger.info("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = joinPoint.getArgs();

        // loop over the args and print them out
        for (Object arg : args) {
            logger.info(arg.toString());

            if (arg instanceof Account) {
                // downcast and print account specific stuff
                Account account = (Account) arg;
                logger.info("account name: " + account.getName());
                logger.info("account level: " + account.getLevel());

            }

        }

    }


    // utility
    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts
        for (Account account : result) {
            // get uppercase version of name
            String upperCaseName = account.getName().toUpperCase();

            // update the name on the account
            account.setName(upperCaseName);
        }

    }

}


















