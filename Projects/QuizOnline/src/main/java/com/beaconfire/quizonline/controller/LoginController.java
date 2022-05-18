package com.beaconfire.quizonline.controller;

import com.beaconfire.quizonline.domain.User;
import com.beaconfire.quizonline.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public ModelAndView getLogin(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
//
        if (session != null && session.getAttribute("user") != null) {
            model.addAttribute("title", "Quiz");
            User user = (User) session.getAttribute("user");
            if (user.isAdmin()) {
                return new ModelAndView("redirect:/admin");
            }
            return new ModelAndView("redirect:/quiz");
        }
        model.addAttribute("title", "Login");
        return new ModelAndView("login");
    }

    // validate that we are always getting a new session after login
    @PostMapping("/login")
    public ModelAndView postLogin(@RequestParam(name = "email") String email,
                                  @RequestParam(name = "password") String password,
                                  HttpServletRequest request) {

        User possibleUser = loginService.validateLogin(email, password);
//        User possibleUser = loginService.validateLogin("ping@pong.com", "pingpong");
//        User possibleUser = loginService.validateLogin("admin@quiz.com", "admin");
        if (possibleUser.getUserId() > 0 && possibleUser.isActive()) {
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) oldSession.invalidate();
            HttpSession newSession = request.getSession(true);
            newSession.setAttribute("user", possibleUser);
            if (possibleUser.isAdmin()) {
                return new ModelAndView("redirect:/admin");
            }
            return new ModelAndView("redirect:/quiz");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, Model model) {
        HttpSession oldSession = request.getSession(false);
        // invalidate old session if it exists
        if (oldSession != null) oldSession.invalidate();
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/register")
    public ModelAndView register(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            model.addAttribute("title", "Quiz");
            User user = (User) session.getAttribute("user");
            if (user.isAdmin()) {
                return new ModelAndView("redirect:/admin");
            }
            return new ModelAndView("redirect:/quiz");
        }
        model.addAttribute("title", "Register");
        model.addAttribute("user", new User());
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView postRegister(User newUser,
                                     HttpServletRequest request, Model model) {
        User testUser = loginService.getUserByEmail(newUser.getEmail());
        model.addAttribute("title", "Register");
        if (testUser.getUserId() < 1) {
            loginService.createNewUser(newUser);
            return new ModelAndView("redirect:/login");
        } else {
            newUser.setMessage("Email Already Exist!");
            model.addAttribute("user", newUser);
            return new ModelAndView("register");
        }

    }

}
