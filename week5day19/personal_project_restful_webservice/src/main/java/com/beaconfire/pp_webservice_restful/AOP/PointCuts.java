package com.beaconfire.pp_webservice_restful.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCuts {
    @Pointcut("within(com.beaconfire.pp_webservice_restful.controller.*)")
    public void inControllerLayer(){}
//    @Pointcut("bean(*service)")
//    public void inService(){}
    @Pointcut("within(com.beaconfire.pp_webservice_restful.controller.*)")
    public void inService(){}
    @Pointcut("execution(* com.beaconfire.pp_webservice_restful.dao.hibernate.User*.getUserById(..))")
    public void inDAOLayer(){}
}
