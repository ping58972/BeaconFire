package com.beaconfire.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class Tennis implements Coach{
    List<String> schedule;
    Random random;
    @PostConstruct
    public void init(){
        schedule = Arrays.asList("I like play Tennis on Monday","I like play Tennis on Monday",
                "I like play Tennis on Tuesday",
                "I like play Tennis on Wednesday",
                "I like play Tennis on Thursday",
                "I like play Tennis on Friday");
        Collections.shuffle(schedule);
        random = new Random();

    }
    @Override
    public void getDailyWorkOutSchedule() {
        System.out.println(schedule.get(random.nextInt(schedule.size())));
    }
}
