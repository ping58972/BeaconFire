package com.beaconfire.pp_webservice_restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication //(exclude = {SecurityAutoConfiguration.class})
public class PersonalProjectRestfulWebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalProjectRestfulWebserviceApplication.class, args);
    }

}
