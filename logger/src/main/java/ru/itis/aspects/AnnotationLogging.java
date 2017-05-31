package ru.itis.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import ru.itis.group.listener.Listener;

import java.lang.reflect.Method;


@Aspect
@Component
public class AnnotationLogging {
    private static final Logger LOGGER = Logger.getLogger(AnnotationLogging.class);

    @Before("execution(* ru.itis.Audition.*(..))")
    public void logBefore() {
        LOGGER.info("Method is calling...");
    }

    @After("execution(* ru.itis.group.listener.Listener.*(..))")
    public void logAfter(){
        LOGGER.info("Method finished.");
    }

    @AfterReturning("execution(* ru.itis.group.MusicianFactory.getMusician(..))")
    public void logAfterSuccess() {
        LOGGER.info("Method successfully returned value");
    }

    @AfterThrowing("execution(* ru.itis.Audition.start())")
    public void logAfterException() {
        LOGGER.error("Method throws an exception!");
    }

    @Around("execution(* ru.itis.Audition.setListener(..)) && args(listener)")
    public void logAround(ProceedingJoinPoint joinPoint, Listener listener) {
        String methodName = getMethodName(joinPoint);
        LOGGER.info("Method \"" + methodName + "\" is calling with argument = " + listener + "...");
        try {
            joinPoint.proceed(new Object[]{listener});
            LOGGER.info("Method \"" + methodName + "\" called.");
        } catch (Throwable throwable) {
            LOGGER.error("Method \"" + methodName + "\" throws an exception: " + throwable.getMessage());
        }
    }

    private String getMethodName(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        return method.getName();
    }
}
