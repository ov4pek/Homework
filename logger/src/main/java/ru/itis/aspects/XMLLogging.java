package ru.itis.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import ru.itis.group.listener.Listener;

import java.lang.reflect.Method;

public class XMLLogging {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(XMLLogging.class));

    public void logBefore(){
        LOGGER.info("Method is calling");
    }

    public void logAfter(){
        LOGGER.info("Method called");
    }

    public void logAfterSuccess() {
        LOGGER.info("Method successfully returned value");
    }

    public void logAfterException() {
        LOGGER.error("Method throws an exception!");
    }

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
