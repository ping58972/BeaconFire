package com.beaconfire.quizrestful.controller;

import com.beaconfire.quizrestful.domain.AllQuizResponse;
import com.beaconfire.quizrestful.domain.Quiz;
import com.beaconfire.quizrestful.domain.common.ResponseStatus;
import com.beaconfire.quizrestful.exception.QuizNotFoundException;
import com.beaconfire.quizrestful.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
