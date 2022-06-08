package com.bfs.compositiveservice.controller;

import com.bfs.compositiveservice.client.CoreClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compositive")
public class DemoController {
    @Autowired
    CoreClient coreClient;

    @GetMapping("/test")
    public ResponseEntity test1(){
        return ResponseEntity.ok("test from service 2");
    }

    @GetMapping("/circuitdemo")
    @CircuitBreaker(name="backendA",fallbackMethod = "circuitBreaker")
    public ResponseEntity<String> circuitDemo(){
        return coreClient.test();
    }

    public ResponseEntity<String> circuitBreaker(Throwable t){
        return ResponseEntity.ok("circuit breaker open");
    }


    @GetMapping("/ratelimiterdemo")
    @RateLimiter(name="backendB",fallbackMethod = "rateLimiter")
    public ResponseEntity<String> ratelimiterDemo(){
        return coreClient.test();
    }

    public ResponseEntity<String> rateLimiter(Throwable t){
        return ResponseEntity.ok("rate limit!");
    }


    @GetMapping("/retrydemo")
    @Retry(name="backendC",fallbackMethod = "retry")
    public ResponseEntity<String> retryDemo(){
        System.out.println("execute...");
        //test111
        return coreClient.test();
    }

    public ResponseEntity<String> retry(Throwable t){
        return ResponseEntity.ok("wait for retry");
    }

}
