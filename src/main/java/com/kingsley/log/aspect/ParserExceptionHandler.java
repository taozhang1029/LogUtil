package com.kingsley.log.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.ho.yaml.exception.YamlException;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Time : 2021/7/30 2:39
 * @Author : Kingsley
 * @Project : color-log-util
 * @File : ParserExceptionHandler.java
 * @IDE : IntelliJ IDEA
 */
@Aspect
@Component
public class ParserExceptionHandler {

    @Pointcut("execution(* com.kingsley.log.config.ConfigParser.*(..))")
    public void config(){

    }

    // 执行前
    @Before(value = "config()")
    public void before(JoinPoint point){
        System.out.println("执行前");
    }

    // 执行中
    @Around(value = "config()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            return proceedingJoinPoint.proceed();
        } catch (YamlException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
