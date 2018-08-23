package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.demo.controller.HelloController.*(..))")
    public void log() {

    }

    @Before("log()")
    public void logBefore(JoinPoint joinPoint) {
//        logger.info("before");
//        logger.error();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //class method
        logger.info("class method={}", joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        //parameter
        logger.info("parameter={}", joinPoint.getArgs());
    }

//    @After("log()")
//    public void logAfter() {
//        logger.info("after");
//    }
//    @AfterReturning(returning = "object", pointcut = "log()")
//    public void logAfterReturning(Object object) {
//        logger.info("response={}", object.toString());
//    }
}
