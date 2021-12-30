package com.example.aop.after.aspect;

import com.example.aop.after.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class LoggingAspect  {

    @AfterThrowing(
            pointcut = "execution(* com.example.aop.after.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n\t-----> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n\t-----> The exception is: " + exc);

    }


    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.example.aop.after.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        // print out witch method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n\t-----> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n\t-----> Result is: " + result);

        // let's post-process the data ... let's modify it :-]

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        // print out the results of the method call
        System.out.println("\n\t-----> Result is: " + result);
    }



    // join point gives us metadata about the methods we are calling
    @Before("com.example.aop.after.aspect.UtilityExpressions.forDaoPackageNoGetterOrSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n\t-> Executing @Before advice on method()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = joinPoint.getArgs();

        // loop over the args and print them out
        for (Object arg : args) {
            System.out.println(arg);

            if (arg instanceof Account) {
                // downcast and print account specific stuff
                Account account = (Account) arg;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());

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


















