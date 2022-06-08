package com.bfs.bookstore.controller;

import com.bfs.bookstore.client.MovieClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private MovieClient movieClient;

    @GetMapping("/movieMessage")
    public ResponseEntity<String> getMessageFromMovie() {
        return movieClient.getMessage();
    }

    @GetMapping("/message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Greeting from book micro");
    }
}