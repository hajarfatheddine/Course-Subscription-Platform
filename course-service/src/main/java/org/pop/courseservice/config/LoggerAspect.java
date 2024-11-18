package org.pop.courseservice.config;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.pop.courseservice.exceptions.BusinessException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggerAspect {
    @Pointcut("forControllerPackage()")
    public void forTheApplication(){
        //pointCut for the entire application flow
    }
    @Pointcut("execution(* org.pop.courseservice.controllers.*.*(..))")
    public void forControllerPackage(){
        // pointcut for the controllers package
    }

    @Before("forTheApplication()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        Object[] arguments = joinPoint.getArgs();
        log.info("---------------------------------------------------");
        log.info("Start services call : " + method);
        log.info("With args : " + Arrays.toString(arguments));
        log.info("---------------------------------------------------");
    }
    @AfterReturning(pointcut = "forTheApplication()", returning = "response")
    public void afterReturning(Object response){
        log.info("---------------------------------------------------");
        log.info("Service Response : " + response);
        log.info("---------------------------------------------------");
    }
    @AfterThrowing(pointcut = "forTheApplication()", throwing = "businessException")
    public void afterThrowing(BusinessException businessException){
        log.info("---------------------------------------------------");
        log.warn("Service Response : " + businessException);
        log.info("---------------------------------------------------");
    }

    @After("forTheApplication()")
    public void after(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        log.info("---------------------------------------------------");
        log.info("End services call : " + method);
        log.info("---------------------------------------------------");
    }
}
