package com.beaconfire.asynchronous.AsyncRestApp.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCut {

    @Pointcut("within(com.beaconfire.asynchronous.AsyncRestApp.controller.*)")
    public void inControllerLayer(){}

}
