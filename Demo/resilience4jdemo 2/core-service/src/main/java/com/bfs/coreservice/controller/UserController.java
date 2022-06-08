package com.bfs.coreservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/core")
public class UserController {
    @GetMapping("/user")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("user info");
    }

//    @PostMapping("/onboar")
//    @Requ
}
