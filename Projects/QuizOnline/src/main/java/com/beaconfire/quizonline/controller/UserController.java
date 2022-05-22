package com.beaconfire.quizonline.controller;

import com.beaconfire.quizonline.domain.User;
import com.beaconfire.quizonline.domain.jdbc.UserJdbc;
import com.beaconfire.quizonline.service.LoginService;
import com.beaconfire.quizonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    public ModelAndView postRegister(UserJdbc newUser,
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


    @GetMapping("/admin/user/all")
    public ModelAndView allUser(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
            return new ModelAndView("user-list");
        }
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/admin/user/suspend/{id}")
    public ModelAndView adminUserSuspend(@PathVariable int id, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
            userService.changeActiveUserById(id);
            return new ModelAndView("redirect:/admin/user/all");
        }
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/admin/user/profile/{id}")
    public ModelAndView adminUserProfile(@PathVariable int id, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
            User user1 = userService.getUserById(id);
            user1.setAdmin(true);
            model.addAttribute("userA", user1);
            return new ModelAndView("admin-user-profile");
        }
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/admin/user/profile/{id}")
    public ModelAndView postUserProfile(UserJdbc newUser,
                                        HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            user.setAdmin(true);
            model.addAttribute("user", user);
            User oldUser = loginService.getUserByEmail(newUser.getEmail());
            model.addAttribute("title", "Profile");
            if (oldUser.getUserId() > 0) {
                newUser.setUserId(oldUser.getUserId());
                User userA = userService.updateUser(newUser);
                userA.setAdmin(true);
                model.addAttribute("userA", userA);
                return new ModelAndView("admin-user-profile");
            } else {
                newUser.setMessage("Some thing Wrong!");
                newUser.setAdmin(true);
                model.addAttribute("userA", newUser);
                return new ModelAndView("admin-user-profile");
            }
        }
        return new ModelAndView("redirect:/login");

    }


}
