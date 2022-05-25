package com.bfs.hibernateprojectdemo.controller;

import com.bfs.hibernateprojectdemo.domain.Question;
import com.bfs.hibernateprojectdemo.domain.hibernate.QuestionHibernate;
import com.bfs.hibernateprojectdemo.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    @ResponseBody
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/question/{id}")
    @ResponseBody
    public Question getQuestionById(@PathVariable int id) {
        return questionService.getQuestionById(id);
    }

    @PostMapping("/question")
    @ResponseBody
    public void addQuestion(@RequestParam String description,
                            @RequestParam boolean isActive) {

        QuestionHibernate question1 = QuestionHibernate.builder()
                .description(description)
                .isActive(isActive)
                .build();

        QuestionHibernate question2 = QuestionHibernate.builder()
                .description("question 2: " + description)
                .isActive(isActive)
                .build();

        questionService.addQuestion(question1, question2);
    }
}
