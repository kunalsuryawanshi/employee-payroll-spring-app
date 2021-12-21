package com.bridgelabz.employeepayrollapp.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Purpose: To Define AOP
 *
 * @author : Kunal Suryawanshi
 * @since : 13-12-2021
 */
@Component
@Aspect
public class LoggingAdvice {
    Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value = "execution(* com.bridgelabz.employeepayrollapp.service.*.*(..) )")
    public void pointcut() {
    }

    /**
     * Purpose : Defining log message with class, method names & parameters used in method.
     *
     * @param proceedingJoinPoint : When invoked, the code execution jumps to the next advice or to the target method.
     * @return objectAfterProceeding : It's the response of that method.
     * @throws Throwable :  constructing JSON parser ( JsonParser ) and generator ( JsonGenerator ) instances and also
     *                   exception for proceed.
     */
    @Around("pointcut()")
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getTarget().getClass().toString();
        Object[] array = proceedingJoinPoint.getArgs();
        logger.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
                + Arrays.toString(array));
        Object object = proceedingJoinPoint.proceed();
        logger.info(className + " : " + methodName + "()" + "Response : "
                + object);
        return object;
    }
}