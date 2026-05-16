package com.company.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAop {

    // Pointcut using execution expression
    @Pointcut("execution(public * com.company.service.BusinessClass.add())")
    public void pointCutExp() {

    }

    // Pointcut using annotation
    @Pointcut("@annotation(com.company.myannotation.MyAnno)")
    public void pointCutExp2() {

    }

    @Before("pointCutExp2()")
    public void beginTxn() {

        System.out.println("Transaction Started");
    }

    @After("pointCutExp2()")
    public void sendReport() {

        System.out.println("Transaction Report Shared");
    }

    @AfterReturning("pointCutExp2()")
    public void commitTxn() {

        System.out.println("Transaction Committed");
    }

    @AfterThrowing(value = "pointCutExp2()", throwing = "th")
    public void rollBackTxn(Throwable th) {

        System.out.println(
                "Transaction Rolled Back : "
                        + th.getMessage());
    }

    // Around Advice
    @Around("pointCutExp2()")
    public Object aroundTest(ProceedingJoinPoint jp)
            throws Throwable {

        Object obj = null;

        try {

            // Before Advice
            System.out.println(
                    "Transaction Support Initiated");

            obj = jp.proceed();

            // After Returning
            System.out.println(
                    "Transaction Successfully Completed");

        } catch (Throwable t) {

            // Exception Handling
            System.out.println(
                    t.getMessage()
                            + " Transaction Rolled Back");

            throw t;
        }

        // After Advice
        System.out.println("Report Emailed");

        return obj;
    }
}