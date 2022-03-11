package com.codegym.cms;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Pointcut("execution(* com.codegym.cms.controller.CustomerController.*(..))")
    public  void addMethodPointCut(){
    }
    @Before("addMethodPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.out.println("start method");
    }
}
