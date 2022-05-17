package com.beaconfire.quizonline.controller;

import com.beaconfire.quizonline.domain.Contact;
import com.beaconfire.quizonline.domain.Feedback;
import com.beaconfire.quizonline.domain.Quiz;
import com.beaconfire.quizonline.domain.User;
import com.beaconfire.quizonline.service.ContactService;
import com.beaconfire.quizonline.service.FeedbackService;
import com.beaconfire.quizonline.service.QuizServive;
import com.beaconfire.quizonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    private final UserService userService;
    private final QuizServive quizServive;
    private final FeedbackService feedbackService;
    private final ContactService contactService;

    @Autowired
    public AdminController(UserService userService, QuizServive quizServive, FeedbackService feedbackService, ContactService contactService) {
        this.userService = userService;
        this.quizServive = quizServive;
        this.feedbackService = feedbackService;
        this.contactService = contactService;
    }

    @GetMapping("/admin")
    public ModelAndView admin(HttpServletRequest request, Model model) {
        model.addAttribute("title", "Quiz");
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
//            model.addAttribute("user", user);
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
            List<Quiz> quizzes = quizServive.getAllQuiz();
            model.addAttribute("quizzes", quizzes);
            List<Feedback> feedbacks = feedbackService.getAllFeedback();
            model.addAttribute("feedbacks", feedbacks);
            List<Contact> contacts = contactService.getAllContact();
            model.addAttribute("contacts", contacts);
            return new ModelAndView("admin");
        }
        return new ModelAndView("redirect:/login");
    }
}
