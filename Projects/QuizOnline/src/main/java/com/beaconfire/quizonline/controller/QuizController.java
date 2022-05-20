package com.beaconfire.quizonline.controller;

import com.beaconfire.quizonline.domain.*;
import com.beaconfire.quizonline.service.QuizServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class QuizController {

    private final QuizServive quizServive;

    private Quiz takeQuiz;

    @Autowired
    public QuizController(QuizServive quizServive) {
        this.quizServive = quizServive;

    }


    @GetMapping("/quiz")
    public String getHome(HttpServletRequest request, Model model) {
        model.addAttribute("title", "Quiz");
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            model.addAttribute("title", "Quiz");
            User user = (User) session.getAttribute("user");
            model.addAttribute("user", user);
            List<Quiz> quizzes = quizServive.getAllQuizByUser(user.getUserId());
            model.addAttribute("quizzes", quizzes);
            List<Category> categories = quizServive.getAllCategory();
            model.addAttribute("categories", categories);
            model.addAttribute("title", "Quiz");
            return "quiz";
        }
        return "login";
    }

    @GetMapping("/quiz/table/{id}/new")
    public String newQuizTable(@PathVariable Integer id,
                               HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            takeQuiz = quizServive.getNewQuiz(user.getUserId(), id);
            List<QuizQuestion> quizQuestions = takeQuiz.getQuizQuestionMap().values()
                    .stream().sorted((q1, q2) -> q1.getOrderNum() - q2.getOrderNum()).collect(Collectors.toList());
            QuizQuestion qq = quizQuestions.get(0);
            model.addAttribute("cateId", id);
            model.addAttribute("quizQuestion", qq);
            model.addAttribute("takeQuiz", takeQuiz);
            model.addAttribute("quizQuestions", quizQuestions);
            model.addAttribute("page_num", 1);
            model.addAttribute("title", "Quiz Table");
            HttpSession timeSession = request.getSession(true);
            timeSession.setAttribute("startTime", new Timestamp(System.currentTimeMillis()));
            timeSession.setAttribute("endTime", new Timestamp(System.currentTimeMillis() + 10000));
            return "quiz-table";
        }
        return "login";
    }

    @GetMapping("/quiz/table/{id}/question/{num}")
    public String quizTable(@PathVariable Integer id, @PathVariable Integer num,
                            HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            List<QuizQuestion> quizQuestions = takeQuiz.getQuizQuestionMap().values()
                    .stream().sorted((q1, q2) -> q1.getOrderNum() - q2.getOrderNum()).collect(Collectors.toList());
            QuizQuestion qq = quizQuestions.get(num - 1);
            model.addAttribute("cateId", id);
            model.addAttribute("quizQuestion", qq);
            model.addAttribute("quizQuestions", quizQuestions);
            model.addAttribute("takeQuiz", takeQuiz);
            model.addAttribute("page_num", num);
            model.addAttribute("title", "Quiz Table");

            return "quiz-table";
        }
        return "login";
    }

    @PostMapping("/quiz/table/{id}/question/{num}")
    public RedirectView quizTablePost(@PathVariable Integer id, @PathVariable Integer num,
                                      QuizQuestion qq,
                                      HttpServletRequest request, Model model, RedirectAttributes redir) {
        HttpSession session = request.getSession(false);
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            List<QuizQuestion> quizQuestions = takeQuiz.getQuizQuestionMap().values()
                    .stream().sorted((q1, q2) -> q1.getOrderNum() - q2.getOrderNum()).collect(Collectors.toList());
            QuizQuestion quizQuestion = quizQuestions.get(num - 1);

            if (qq.getUserChoiceId() > 0 || qq.getUserShortAnswer() != null) {
                if (qq.getUserChoiceId() > 0) {

                    quizQuestion.setUserChoiceId(qq.getUserChoiceId());
                    quizQuestion.setMarked(true);
                    redir.addFlashAttribute("isSuccess", true);
                }
                if (qq.getUserShortAnswer().length() != 0 && !qq.getUserShortAnswer().equals(",,,")) {
                    quizQuestion.setUserShortAnswer(qq.getUserShortAnswer());
                    quizQuestion.setMarked(true);
                    redir.addFlashAttribute("isSuccess", true);
                }
                boolean isSuccess = quizServive.updateQuizQuestion(quizQuestion);
            }
            if (num < 10) {
                num++;
            }

            rv.setUrl("/quiz/table/" + id + "/question/" + num);
            return rv;
        }
        rv.setUrl("/login");
        return rv;
    }

    @GetMapping("/quiz/result/{quizId}")
    public String quizResult(@PathVariable Integer quizId,
                             HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            quizServive.setEndTimeById(quizId);
            Quiz quizResult = quizServive.getQuizById(quizId);
            List<QuizQuestion> quizQuestions = quizResult.getQuizQuestionMap().values()
                    .stream().sorted((q1, q2) -> q1.getOrderNum() - q2.getOrderNum()).collect(Collectors.toList());
            int score = quizQuestions.stream().map(qq -> {
                Question q = qq.getQuestion();
                if (q.getType().equals("MULTIPLE_CHOICE")) {
                    Choice choice = q.getChoiceMap().get(qq.getUserChoiceId());
                    if (choice == null) {
                        qq.setCorrect(false);
                        qq.setMessage("The Answer was not Selected!");
                        return 0;
                    }
                    if (choice.isCorrect()) {
                        qq.setCorrect(true);
                        qq.setMessage("Got Correct!");
                        return 1;
                    }
                    qq.setCorrect(false);
                    qq.setMessage("Got Wrong Answer");
                    return 0;
                } else if (q.getType().equals("SHORT_ANSWER")) {
                    Choice choice = q.getChoiceMap().values().stream().findFirst().orElse(new Choice());
                    return choice.getChoiceDesription().equals(qq.getUserShortAnswer()) ? 1 : 0;
                }
                return 0;
            }).reduce(0, (a, b) -> a + b);
            quizResult.setScore(score);
            model.addAttribute("quizQuestions", quizQuestions);
            model.addAttribute("quizResult", quizResult);
            model.addAttribute("title", "Quiz Result");
            return "quiz-result";
        }
        return "login";
    }
}
