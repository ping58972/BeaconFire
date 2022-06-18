package com.beaconfire.quizrestful.controller;

import com.beaconfire.quizrestful.domain.AllQuizResponse;
import com.beaconfire.quizrestful.domain.UserQuizzesResponse;
import com.beaconfire.quizrestful.domain.common.ResponseStatus;
import com.beaconfire.quizrestful.exception.QuizNotFoundException;
import com.beaconfire.quizrestful.exception.UserNotFoundException;
import com.beaconfire.quizrestful.service.AsyncService;
import com.beaconfire.quizrestful.service.QuizService;
import com.beaconfire.quizrestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("async")
public class UserQuizAsyncController {
    private final UserService userService;
    private final QuizService quizService;
    private final AsyncService asyncService;
    @Autowired
    public UserQuizAsyncController(UserService userService, QuizService quizService, AsyncService asyncService) {
        this.userService = userService;
        this.quizService = quizService;
        this.asyncService = asyncService;
    }

    @GetMapping("/user/{userId}/allQuiz")
    @PreAuthorize("hasAnyAuthority('read')")
    public ResponseEntity<UserQuizzesResponse> getAllQuizzesByUserIdAsync(@PathVariable int userId) throws QuizNotFoundException, UserNotFoundException {
        return ResponseEntity.ok(UserQuizzesResponse.builder().status(ResponseStatus.builder()
                        .success(true).message("Returning all Quizzes by User Id - Async.").build())
                .userQuizzes(asyncService.getUserQuizzesByUserIdAsync(userId)).build());

    }
}
