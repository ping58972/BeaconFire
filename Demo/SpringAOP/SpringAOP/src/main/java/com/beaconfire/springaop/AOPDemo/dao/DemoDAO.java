package com.beaconfire.springaop.AOPDemo.dao;


import com.beaconfire.springaop.AOPDemo.domain.Demo;
import com.beaconfire.springaop.AOPDemo.exception.DemoNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class DemoDAO {
    public Demo getADemo(){
        return Demo.builder()
                .id(1)
                .type("Java")
                .description("AOP")
                .build();
    }

    public Demo getAErrorDemo() throws DemoNotFoundException {
        throw new DemoNotFoundException("Demo not found.");
    }
}
