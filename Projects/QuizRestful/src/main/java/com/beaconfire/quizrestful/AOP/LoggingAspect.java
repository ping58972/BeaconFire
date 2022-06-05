package com.beaconfire.quizrestful.AOP;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @Before("com.beaconfire.quizrestful.AOP.PointCuts.inControllerLayer()")
//    public void logStartTime(){
//        logger.info("From LoggingAspect.logStartTime in controller: " + System.currentTimeMillis());
//    }
//    @After("com.beaconfire.quizrestful.AOP.PointCuts.inService()")
//    public void logEndTime(JoinPoint joinPoint){
//        logger.info("From LoggingAspect.logEndTime in service: " + System.currentTimeMillis()  + ": " + joinPoint.getSignature());
//    }
//
//    @AfterReturning(value = "com.beaconfire.quizrestful.AOP.PointCuts.inDAOLayer()", returning = "res")
//    public void logReturnObject(JoinPoint joinPoint, Object res){
//        logger.info("From LoggingAspect.logReturnObject in DAO: " + res + ": " + joinPoint.getSignature());
//    }
//    @AfterThrowing(value = "com.beaconfire.quizrestful.AOP.PointCuts.inControllerLayer()", throwing = "ex")
//    public void logThrownException(JoinPoint joinPoint, Throwable ex){
//        logger.error("From LoggingAspect.logThrownException in controller: " + ex.getMessage() + ": " + joinPoint.getSignature());
//    }

//    @Around("com.beaconfire.quizrestful.AOP.PointCuts.inDAOLayer()")
//    public User logStartAndEndTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        logger.info("From LoggingAspect.logStartAndEndTime: " + proceedingJoinPoint.getSignature());
//        logger.info("Start time: " + System.currentTimeMillis());
//
//        User user = (User) proceedingJoinPoint.proceed();
//
//        logger.info("End time: " + System.currentTimeMillis());
//
//        return user;
//    }

//    @Around("com.beaconfire.quizrestful.AOP.PointCuts.inControllerLayer()")
//    public void logExecutionTimeAllController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        logger.info("From LoggingAspect.logStartAndEndTime: " + proceedingJoinPoint.getSignature());
//        long startTime = System.currentTimeMillis();
//        logger.info("Start time: " + startTime +"ms.");
//        Object obj = proceedingJoinPoint.proceed();
//        logger.info("The return Object is: "+obj.toString());
//        long endTime = System.currentTimeMillis();
//        logger.info("End time: " + endTime + "ms.");
//        logger.info(""+ proceedingJoinPoint.getSignature()+" --> execution time is:"+ (endTime - startTime) + "ms.");
//    }
}
