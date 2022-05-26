package com.beaconfire.springaop.ProxyDemo;

public class You implements Person{
    @Override
    public void getAJob() {
        System.out.println("Get a job");
    }
}
