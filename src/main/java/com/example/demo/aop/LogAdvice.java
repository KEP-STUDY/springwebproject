package com.example.demo.aop;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Slf4j
@Component
// Pointcut
public class LogAdvice {
    @Before("execution(* com.example.demo.service.SampleService*.*(..))")
    public void logBefore() {
        log.info("===============================");
    }

    @Before("execution(* com.example.demo.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
    public void logBeforeWithParam(String str1, String str2) {
        log.info("Str1: " + str1);
        log.info("Str2: " + str2);
    }

    @AfterThrowing(pointcut = "execution(* com.example.demo.service.SampleService*.*(..))", throwing = "exception")
    public void logException(Exception exception) {
        log.info("Exception...!!!");
        log.info("exception: " + exception);
    }

    @Around("execution(* com.example.demo.service.SampleService*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();

        log.info("Target: " + pjp.getTarget());
        log.info("Param: " + Arrays.toString(pjp.getArgs()));

        //invoke method
        Object result = null;

        try {
            result = pjp.proceed();
        }catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        log.info("TIME: " + (end - start));

        return result;
    }
}
