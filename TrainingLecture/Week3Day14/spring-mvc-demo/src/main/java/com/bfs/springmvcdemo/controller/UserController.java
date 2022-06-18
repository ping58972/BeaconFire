package com.bfs.springmvcdemo.controller;

import com.bfs.springmvcdemo.domain.User;
import com.bfs.springmvcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/api/user")
    @ResponseBody
    public User getUserByUsername(@RequestParam String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping("/api/user")
    @ResponseBody
    public String createNewUser(@RequestBody User user) {
        userService.createNewUser(user);
        return "User inserted";
    }

    @GetMapping("/user")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user";
    }

    @PostMapping("/user")
    public String createNewUser(@RequestParam int id,
                                @RequestParam String username,
                                @RequestParam String password,
                                Model model) {
        userService.createNewUser(new User(id, username, password));
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user";
    }
}
