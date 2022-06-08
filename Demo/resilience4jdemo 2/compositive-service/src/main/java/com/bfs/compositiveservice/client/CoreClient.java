package com.bfs.compositiveservice.client;

import feign.RequestLine;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name="core-service")
public interface CoreClient {

    @GetMapping("/core/user")
    ResponseEntity<String> test();
}
