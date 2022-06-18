package com.beaconfire.quizrestful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication //(exclude = {SecurityAutoConfiguration.class})
@EnableTransactionManagement
@EnableAsync
@EnableScheduling
@EnableCaching
public class QuizRestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizRestfulApplication.class, args);
    }

}
