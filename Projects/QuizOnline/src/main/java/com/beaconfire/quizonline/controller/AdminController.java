package com.beaconfire.quizonline.controller;

import com.beaconfire.quizonline.domain.*;
import com.beaconfire.quizonline.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AdminController {
    private final UserService userService;
    private final QuizServive quizServive;
    private final FeedbackService feedbackService;
    private final ContactService contactService;
    private final LoginService loginService;


    @Autowired
    public AdminController(UserService userService, QuizServive quizServive, FeedbackService feedbackService, ContactService contactService, LoginService loginService) {
        this.userService = userService;
        this.quizServive = quizServive;
        this.feedbackService = feedbackService;
        this.contactService = contactService;
        this.loginService = loginService;
    }

    @GetMapping("/admin")
    public ModelAndView admin(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
            List<Category> categories = quizServive.getAllCategory();
            model.addAttribute("categories", categories);
            return new ModelAndView("categories");
        }
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/admin/quiz/all")
    public ModelAndView allQuiz(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
            List<Quiz> quizzes = quizServive.getAllQuiz();
            model.addAttribute("quizzes", quizzes);
            List<Category> categories = quizServive.getAllCategory();
            model.addAttribute("categories", categories);
            return new ModelAndView("quiz-list");
        }
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/admin/quiz/{categoryId}")
    public ModelAndView allQuizByCategoryId(@PathVariable int categoryId, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
            List<Quiz> quizzes = quizServive.getAllQuiz()
                    .stream().filter(quiz -> quiz.getCategoryId() == categoryId).collect(Collectors.toList());
            model.addAttribute("quizzes", quizzes);
            List<Category> categories = quizServive.getAllCategory();
            model.addAttribute("categories", categories);
            return new ModelAndView("quiz-list");
        }
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/admin/quiz/result/{tf}")
    public ModelAndView allQuizByResult(@PathVariable int tf, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
            List<Quiz> quizzes = quizServive.getAllQuiz()
                    .stream().filter(quiz -> tf == 1 ? quiz.getScore() > 6 : quiz.getScore() <= 6).collect(Collectors.toList());
            model.addAttribute("quizzes", quizzes);
            List<Category> categories = quizServive.getAllCategory();
            model.addAttribute("categories", categories);
            return new ModelAndView("quiz-list");
        }
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/admin/quiz/result/search")
    public ModelAndView allQuizBySearch(@RequestParam(name = "search") String search,
                                        HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
            List<Quiz> quizzes = quizServive.getAllQuiz()
                    .stream().filter(quiz -> quiz.getQuizName().toLowerCase().contains(search.toLowerCase())).collect(Collectors.toList());
            model.addAttribute("quizzes", quizzes);
            List<Category> categories = quizServive.getAllCategory();
            model.addAttribute("categories", categories);
            return new ModelAndView("quiz-list");
        }
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/admin/feedback/all")
    public ModelAndView allFeedback(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
            List<Feedback> feedbacks = feedbackService.getAllFeedback();
            model.addAttribute("feedbacks", feedbacks);
            return new ModelAndView("feedback-list");
        }
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/admin/contact/all")
    public ModelAndView allContactMessage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
            List<Contact> contacts = contactService.getAllContact();
            model.addAttribute("contacts", contacts);
            return new ModelAndView("contact-list");
        }
        return new ModelAndView("redirect:/login");
    }
}
