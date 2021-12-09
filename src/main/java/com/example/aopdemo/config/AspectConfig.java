package com.example.aopdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;


@Aspect
@Slf4j
@Configuration
public class AspectConfig {

    @Pointcut("within(com.example.aopdemo.controller..*)")
    public void firstAop(){

    }

    @Around("com.example.aopdemo.config.AspectConfig.firstAop()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        log.info("logging .... " + signature.getName());
        var j = joinPoint.proceed();
        log.info("logging continues .... "+ j.toString());
        return j;
    }
}
