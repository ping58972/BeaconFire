package com.beaconfire.quizrestful.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCuts {
    @Pointcut("within(com.beaconfire.quizrestful.controller.*)")
    public void inControllerLayer(){}
//    @Pointcut("bean(*service)")
//    public void inService(){}
    @Pointcut("within(com.beaconfire.quizrestful.controller.*)")
    public void inService(){}
    @Pointcut("execution(* com.beaconfire.quizrestful.dao.hibernate.User*.getUserById(..))")
    public void inDAOLayer(){}
}
