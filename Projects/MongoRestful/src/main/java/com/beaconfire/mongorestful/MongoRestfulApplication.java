package com.beaconfire.mongorestful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MongoRestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoRestfulApplication.class, args);
    }

}
