package com.beaconfire.userservice.controller;

import com.beaconfire.userservice.domain.AllUsersResponse;
import com.beaconfire.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public AllUsersResponse getAllUsers(){
        return AllUsersResponse.builder()
                .users(userService.getAllUsers())
                .build();
    }
}
