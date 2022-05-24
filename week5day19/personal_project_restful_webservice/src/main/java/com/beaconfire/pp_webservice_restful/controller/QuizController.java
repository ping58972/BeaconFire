package com.beaconfire.pp_webservice_restful.controller;

import com.beaconfire.pp_webservice_restful.domain.Quiz;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("quiz")
public class QuizController {


    public List<Quiz> getAllQuizzes() {
        return null;
    }

    public List<Quiz>  getAllQuizzesByUserId(int userId) {
        return null;
    }
}
