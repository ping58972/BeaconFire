package com.beaconfire.model;

import org.springframework.stereotype.Component;

@Component
public class Golf implements Coach{
    @Override
    public void getDailyWorkOutSchedule() {
        System.out.println("I like to play Golf!");
    }
}
