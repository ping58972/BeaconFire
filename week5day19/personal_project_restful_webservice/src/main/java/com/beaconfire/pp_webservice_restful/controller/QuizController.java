package com.beaconfire.pp_webservice_restful.controller;

import com.beaconfire.pp_webservice_restful.dao.QuizDao;
import com.beaconfire.pp_webservice_restful.domain.AllQuizResponse;
import com.beaconfire.pp_webservice_restful.domain.AllUsersResponse;
import com.beaconfire.pp_webservice_restful.domain.Quiz;
import com.beaconfire.pp_webservice_restful.domain.UserResponse;
import com.beaconfire.pp_webservice_restful.domain.common.ResponseStatus;
import com.beaconfire.pp_webservice_restful.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("quiz")
public class QuizController {

    private final QuizService quizService;
    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping()
    public AllQuizResponse getAllQuizzes() {
        try{
            return AllQuizResponse.builder().status(ResponseStatus.builder()
                            .success(true).message("Returning all Quizzes.").build())
                    .quizzes(quizService.getAllQuizzes()).build();
        } catch (Exception e){
            return AllQuizResponse.builder().status(ResponseStatus.builder()
                            .success(false).message("Can not return Any Quizzes.").build())
                    .quizzes(new ArrayList<>()).build();
        }
    }
    @GetMapping("/user/{userId}")
    public AllQuizResponse  getAllQuizzesByUserId(@PathVariable int userId) {
        try{
            return AllQuizResponse.builder().status(ResponseStatus.builder()
                            .success(true).message("Returning all Quizzes by User Id.").build())
                    .quizzes(quizService.getAllQuizzesByUserId(userId)).build();
        } catch (Exception e){
            return AllQuizResponse.builder().status(ResponseStatus.builder()
                            .success(false).message("Can not return Any Quiz by User Id.").build())
                    .quizzes(new ArrayList<>()).build();
        }
    }
}
