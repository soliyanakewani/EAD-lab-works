package com.example.onlinebookstore.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
    @Before("execution(* BookRegistrationServlet.*(..))")
    public void logMethodExecution() {
        System.out.println("Method in BookRegistrationServlet is being executed");
    }
}

