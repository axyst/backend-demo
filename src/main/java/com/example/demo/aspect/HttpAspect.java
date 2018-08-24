package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

// 切点日志
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.demo.controller..*.*(..))")
    public void webLog() {

    }

    @Before("webLog()")
    public void logBefore(JoinPoint joinPoint) throws Throwable {
//        logger.info("before");
//        logger.error();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("URL : " + request.getRequestURL());
        //method
        logger.info("METHOD : " + request.getMethod());
        //ip
        logger.info("IP : " + request.getRemoteAddr());
        //class method
        logger.info("CLASS METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        //parameter
        logger.info("ARG : " + joinPoint.getArgs());
    }

    //    @After("log()")
//    public void logAfter() {
//        logger.info("after");
//        logger.info("response={}", object.toString());
//    }
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }
}
