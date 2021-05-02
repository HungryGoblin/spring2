package ru.geekbrains.product.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointcutDeclarationAspect {

    @Pointcut("execution(* ru.geekbrains.product.controllers..*.*(..))")
    public void controllerPointCut() {
    }

    @Before("controllerPointCut()")
    public void logBefore(JoinPoint joinPoint) {
        // выводим в консоль информацию о текущей точке соединения
        System.out.println(joinPoint);
    }

}
