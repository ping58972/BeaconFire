package com.beaconfire.springaop.ProxyDemo;

public class ProxyDemo {

    public static void main(String[] args) {
        PersonProxy personProxy = new PersonProxy(new You());
        personProxy.getAJob();
    }
}
