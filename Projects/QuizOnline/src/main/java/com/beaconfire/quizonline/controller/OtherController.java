package com.beaconfire.quizonline.controller;

import com.beaconfire.quizonline.domain.Contact;
import com.beaconfire.quizonline.domain.Feedback;
import com.beaconfire.quizonline.domain.User;
import com.beaconfire.quizonline.domain.jdbc.ContactJdbc;
import com.beaconfire.quizonline.domain.jdbc.FeedbackJdbc;
import com.beaconfire.quizonline.service.ContactService;
import com.beaconfire.quizonline.service.FeedbackService;
import com.beaconfire.quizonline.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

@Controller
public class OtherController {
    private final UserService userService;
    private final FeedbackService feedbackService;
    private final ContactService contactService;

    public OtherController(UserService userService, FeedbackService feedbackService, ContactService contactService) {
        this.userService = userService;
        this.feedbackService = feedbackService;
        this.contactService = contactService;
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
            FeedbackJdbc feedback,
            HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            model.addAttribute("title", "Feedback");
            User user = (User) session.getAttribute("user");
            feedback.setFeedbackId(user.getUserId());
            feedback.setFeedbackTime(new Timestamp(System.currentTimeMillis()));
            boolean isSuccess = feedbackService.createNewFeedback(feedback);
            model.addAttribute("user", user);
            model.addAttribute("isSuccess", isSuccess);
            return new ModelAndView("feedback");
        }
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/contact")
    public ModelAndView contact(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            model.addAttribute("title", "Contact");
            User user = (User) session.getAttribute("user");
            model.addAttribute("user", user);
            return new ModelAndView("contact");
        }
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/contact")
    public ModelAndView contact(
            ContactJdbc contact,
            HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            model.addAttribute("title", "Contact");
            User user = (User) session.getAttribute("user");
            model.addAttribute("user", user);

            boolean isSuccess = contactService.createNewContactMessage(contact);
            model.addAttribute("isSuccess", isSuccess);
            return new ModelAndView("contact");
        }
        return new ModelAndView("redirect:/login");
    }

}
