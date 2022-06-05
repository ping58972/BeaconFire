package com.beaconfire.mock_week6day23.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    public void setRestTemplateBuilder(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Bean
    public RestTemplate resTemplate(){
        return restTemplateBuilder.build();
    }
}