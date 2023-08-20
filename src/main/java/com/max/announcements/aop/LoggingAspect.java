package com.max.announcements.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class LoggingAspect {

    @Before("methodsInsideAnnouncementServiceImpl()")
    public void logMethodCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        StringBuilder logMessage = new StringBuilder();
        logMessage.append("Method: ").append(methodName).append(" | Parameters: [");

        for (int i = 0; i < args.length; i++) {
            logMessage.append(args[i]);
            if (i < args.length - 1) {
                logMessage.append(", ");
            }
        }

        logMessage.append("]");

        log.info(logMessage);
    }

    @Pointcut("execution(* com.max.post.service.impl.*.*(..))")
    public void methodsInsideAnnouncementServiceImpl() {
        // Applies to methods in 'com.max.post.service.impl' package with any parameters
    }

}
