package com.beaconfire.quizonline.controller;

import com.beaconfire.quizonline.domain.*;
import com.beaconfire.quizonline.service.*;
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
    public ModelAndView postUserProfile(User newUser,
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
            return new ModelAndView("quiz-list");
        }
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/admin/question/all")
    public ModelAndView allQuestion(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
            List<Question> questions = quizServive.getAllQuestion();
            model.addAttribute("questions", questions);
            List<Category> categories = quizServive.getAllCategory();
            model.addAttribute("categories", categories);
            return new ModelAndView("question-list");
        }
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/admin/question/change/{id}")
    public ModelAndView allQuestion(@PathVariable int id, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
            quizServive.changeActiveQuestionById(id);
            List<Question> questions = quizServive.getAllQuestion();
            model.addAttribute("questions", questions);
            List<Category> categories = quizServive.getAllCategory();
            model.addAttribute("categories", categories);
            return new ModelAndView("question-list");
        }
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/admin/question/all")
    public ModelAndView newQuestion(Question question, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
            boolean isSuccess = quizServive.createNewQuestion(question);
            model.addAttribute("isSuccess", isSuccess);
            List<Category> categories = quizServive.getAllCategory();
            model.addAttribute("categories", categories);
            List<Question> questions = quizServive.getAllQuestion();
            model.addAttribute("questions", questions);
            return new ModelAndView("question-list");
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
