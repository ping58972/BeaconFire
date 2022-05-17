package com.beaconfire.quizonline.controller;

import com.beaconfire.quizonline.domain.Contact;
import com.beaconfire.quizonline.domain.Feedback;
import com.beaconfire.quizonline.domain.User;
import com.beaconfire.quizonline.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class OtherController {
    private final UserService userService;

    public OtherController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        System.out.println("index...");
        return new ModelAndView("redirect:/quiz");
    }

    @GetMapping("/feedback")
    public ModelAndView feedback(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            model.addAttribute("title", "Feedback");
            User user = (User) session.getAttribute("user");
            model.addAttribute("user", user);
            return new ModelAndView("feedback");
        }
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/feedback")
    public ModelAndView feedback(
            Feedback feedback,
            HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            model.addAttribute("title", "Feedback");
            User user = (User) session.getAttribute("user");
            model.addAttribute("user", user);
            System.out.println(feedback);
            return new ModelAndView("feedback");
        }
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/contact")
    public ModelAndView contact(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            model.addAttribute("title", "Feedback");
            User user = (User) session.getAttribute("user");
            model.addAttribute("user", user);
            return new ModelAndView("contact");
        }
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/contact")
    public ModelAndView contact(
            Contact contact,
            HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            model.addAttribute("title", "Contact");
            User user = (User) session.getAttribute("user");
            model.addAttribute("user", user);
            System.out.println(contact);
            return new ModelAndView("contact");
        }
        return new ModelAndView("redirect:/login");
    }

}
