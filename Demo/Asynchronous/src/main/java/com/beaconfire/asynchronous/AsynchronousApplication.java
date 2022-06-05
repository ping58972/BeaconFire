package com.beaconfire.asynchronous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsynchronousApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsynchronousApplication.class, args);
    }

}
