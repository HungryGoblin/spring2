package ru.geekbrains.product.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

public class AopAppLogging {

    @Before("execution(* ru.geekbrains.product.controllers.ProductController..*(..))")
    public void beforeAnyRequest(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.printf("Вызван метод: %s", methodSignature);
    }
}
