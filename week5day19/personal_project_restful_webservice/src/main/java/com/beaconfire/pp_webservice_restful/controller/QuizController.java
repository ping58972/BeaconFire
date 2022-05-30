package com.beaconfire.pp_webservice_restful.controller;

import com.beaconfire.pp_webservice_restful.dao.QuizDao;
import com.beaconfire.pp_webservice_restful.domain.AllQuizResponse;
import com.beaconfire.pp_webservice_restful.domain.AllUsersResponse;
import com.beaconfire.pp_webservice_restful.domain.Quiz;
import com.beaconfire.pp_webservice_restful.domain.UserResponse;
import com.beaconfire.pp_webservice_restful.domain.common.ResponseStatus;
import com.beaconfire.pp_webservice_restful.exception.QuizNotFoundException;
import com.beaconfire.pp_webservice_restful.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('read')")
    public ResponseEntity<AllQuizResponse> getAllQuizzes() {

            return ResponseEntity.ok(AllQuizResponse.builder().status(ResponseStatus.builder()
                            .success(true).message("Returning all Quizzes.").build())
                    .quizzes(quizService.getAllQuizzes()).build());

    }
    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAnyAuthority('read')")
    public ResponseEntity<AllQuizResponse> getAllQuizzesByUserId(@PathVariable int userId) throws QuizNotFoundException {
            return ResponseEntity.ok(AllQuizResponse.builder().status(ResponseStatus.builder()
                            .success(true).message("Returning all Quizzes by User Id.").build())
                    .quizzes(quizService.getAllQuizzesByUserId(userId)).build());

    }
}
