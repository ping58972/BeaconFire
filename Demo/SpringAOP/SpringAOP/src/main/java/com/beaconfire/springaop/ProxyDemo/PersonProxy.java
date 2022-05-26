package com.beaconfire.springaop.ProxyDemo;

public class PersonProxy implements Person{

    Person target;

    public PersonProxy(Person target) {
        this.target = target;
    }

    @Override
    public void getAJob() {
        beforeGettingAJob(); // advice -> "before" advice
        target.getAJob(); // join point
        afterGettingAJob(); // advice -> "after" advice
    }

    public void beforeGettingAJob(){
        System.out.println("Prepare Resume");
    }

    public void afterGettingAJob(){
        System.out.println("Work Hard");
    }

}
