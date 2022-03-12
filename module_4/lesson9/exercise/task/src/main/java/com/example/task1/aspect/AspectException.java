package com.example.task1.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Component
@Aspect
public class AspectException {
    private int visitedNumber =0;
    @Pointcut("execution(* com.example.task1.controller.BookController.payBook(..))")
    public void affterPayBookController(){
    }
    @AfterThrowing("affterPayBookController()")
    public void throwaffterPayBookController(){
        System.out.println("mã đã nhập không đúng");
    }
    @Pointcut("execution(* com.example.task1.controller.BookController.showFormBorrow(..))")
    public void afterBorrowBookController(){
    }

    @AfterThrowing("afterBorrowBookController()")
    public void throwAfterBorrowBookController(){
        System.out.println("Sách đã hết");
    }

    @Pointcut("execution(* com.example.task1.controller.BookController.*(..))")
    public void afterVisittedController(){
    }

    @After("afterVisittedController()")
    public void throwAfterVisittedController(){
        visitedNumber++;
        System.out.println("Số lượt truy cập hiện tại là "+ visitedNumber);
    }
}
