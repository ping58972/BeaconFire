package com.beaconfire.quizonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ServletComponentScan
public class QuizOnlineApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuizOnlineApplication.class, args);
    }
}
