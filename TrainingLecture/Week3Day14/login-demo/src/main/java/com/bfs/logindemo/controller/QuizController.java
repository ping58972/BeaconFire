package com.bfs.logindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class QuizController {

    @GetMapping("/quiz")
    public String getHome() {
        return "quiz";
    }

    @PostMapping("/quiz")
    public String submitQuestion(@RequestParam(name = "math")String choice,
                                 HttpSession session) {
        session.setAttribute("choice", choice);
        return "result";
    }
}
