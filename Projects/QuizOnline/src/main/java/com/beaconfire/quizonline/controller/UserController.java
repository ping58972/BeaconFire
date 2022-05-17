package com.beaconfire.quizonline.controller;

import com.beaconfire.quizonline.domain.User;
import com.beaconfire.quizonline.service.LoginService;
import com.beaconfire.quizonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    private final UserService userService;
    private final LoginService loginService;

    @Autowired
    public UserController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    @GetMapping("/user/profile")
    public ModelAndView getProfile(HttpServletRequest request, Model model) {
        return new ModelAndView("user-profile");
    }

    @PostMapping("/user/profile")
    public ModelAndView postRegister(User newUser,
                                     HttpServletRequest request, Model model) {
        User oldUser = loginService.getUserByEmail(newUser.getEmail());
        model.addAttribute("title", "Profile");
        if (oldUser.getUserId() > 0) {
            newUser.setUserId(oldUser.getUserId());
            User user = userService.updateUser(newUser);
            model.addAttribute("user", user);
            return new ModelAndView("user-profile");
        } else {
            newUser.setMessage("Some thing Wrong!");
            model.addAttribute("user", newUser);
            return new ModelAndView("user-profile");
        }

    }

}
