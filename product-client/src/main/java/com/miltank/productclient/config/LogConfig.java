package com.miltank.productclient.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogConfig {
    @Value("${server.port}")
    private String port;

//    @Pointcut("execution(public * com.miltank.productclient.controller.*.*(..))")
//    public void pointCut(){
//
//    }
//
//    @Around("pointCut()")
//    private String doAround(ProceedingJoinPoint joinPoint){
//        StringBuffer result = new StringBuffer();
//        try {
//            result.append(port+"\n");
//            result.append(joinPoint.proceed());
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        return result.toString();
//    }
}
