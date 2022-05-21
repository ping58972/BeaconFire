package com.beaconfire.quizonline.controller;

import com.beaconfire.quizonline.domain.Category;
import com.beaconfire.quizonline.domain.Question;
import com.beaconfire.quizonline.domain.User;
import com.beaconfire.quizonline.service.QuizServive;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class QuestionController {
    private final QuizServive quizServive;

    public QuestionController(QuizServive quizServive) {
        this.quizServive = quizServive;
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

    @GetMapping("/admin/question/changeState/{id}")
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

    @GetMapping("/admin/question/new")
    public ModelAndView createNewQuestion(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
//            List<Question> questions = quizServive.getAllQuestion();
//            model.addAttribute("questions", questions);
            List<Category> categories = quizServive.getAllCategory();
            model.addAttribute("categories", categories);
            return new ModelAndView("question-form");
        }
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/admin/question/update/{id}")
    public ModelAndView getUpdateQuestion(@PathVariable int id, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin())
                return new ModelAndView("redirect:/quiz");
            model.addAttribute("title", "Admin");
            Question question = quizServive.getQuestionById(id);
            model.addAttribute("question", question);
            System.out.println(question);
            List<Category> categories = quizServive.getAllCategory();
            model.addAttribute("categories", categories);
            return new ModelAndView("question-update");
        }
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/admin/question/update/{id}")
    public RedirectView postUpdateQuestion(Question question, @PathVariable int id, RedirectAttributes redir,
                                           HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        RedirectView rv = new RedirectView();
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if (!user.isAdmin()) {
                rv.setUrl("/quiz");
                return rv;
            }
            model.addAttribute("title", "Admin");
            boolean isSuccess = quizServive.updateQuiestion(question);
            System.out.println(question);

            model.addAttribute("isSuccess", isSuccess);
            List<Category> categories = quizServive.getAllCategory();
            model.addAttribute("categories", categories);
//            List<Question> questions = quizServive.getAllQuestion();
//            model.addAttribute("questions", questions);
            rv.setUrl("/admin/question/update/" + id);
            return rv;
        }
        rv.setUrl("/login");
        return rv;
    }
}
