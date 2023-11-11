package com.gokhan.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ServiceAspect {
    
    @Before("execution(* com.gokhan.aop.service.*.*(..))")
    public void mesajVerMetodudundanOnce(JoinPoint joinPoint){
        System.out.println("mesajver methodundan önce parametre yakalandı" + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
    @After("execution(*c om.gokhan.aop.service.*.*(..))")
    public void  mesajVerMetodudundanSonra(JoinPoint joinPoint){
        System.out.println("mesajver methodundan sonra parametre yakalandı" + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
