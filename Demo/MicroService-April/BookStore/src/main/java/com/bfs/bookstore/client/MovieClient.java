package com.bfs.bookstore.client;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "movie-store", url = "http://localhost:9000",
        fallbackFactory = MovieClientFallbackFactory.class)
public interface MovieClient {

    @RequestLine("GET")
    @RequestMapping("/movie/message")
    ResponseEntity<String> getMessage();
}