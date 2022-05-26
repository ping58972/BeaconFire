package com.beaconfire.springaop.AOPDemo.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCuts {

    @Pointcut("within(com.beaconfire.springaop.AOPDemo.controller.*)")
    public void inControllerLayer(){}

    @Pointcut("bean(*Service)")
    public void inService(){}

    @Pointcut("execution(* com.beaconfire.springaop.AOPDemo.dao.DemoDAO.*Demo())")
    public void inDAOLayer(){}
}
