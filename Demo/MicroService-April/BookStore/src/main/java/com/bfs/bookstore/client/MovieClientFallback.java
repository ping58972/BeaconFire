package com.bfs.bookstore.client;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

//public class MovieClientFallback{
//
//}

public class MovieClientFallback implements MovieClient{
    private final Throwable cause;

    public MovieClientFallback(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public ResponseEntity<String> getMessage() {
        if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
            // Treat the HTTP 404 status
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Message From Fall back:: Not Found");
        }

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Message From Fall back:: Others");
    }
}
