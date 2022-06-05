package com.beaconfire.quizrestful.service;

import com.beaconfire.quizrestful.dao.QuizDao;
import com.beaconfire.quizrestful.dao.UserDao;
import com.beaconfire.quizrestful.domain.Quiz;
import com.beaconfire.quizrestful.domain.QuizQuestion;
import com.beaconfire.quizrestful.domain.User;
import com.beaconfire.quizrestful.domain.UserQuizzes;
import com.beaconfire.quizrestful.exception.QuizNotFoundException;
import com.beaconfire.quizrestful.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    private QuizService quizService;
    private UserService userService;
    @Autowired
    public AsyncService(QuizService quizService, UserService userService) {
        this.quizService = quizService;
        this.userService = userService;
    }

    public UserQuizzes getUserQuizzesByUserIdAsync(int userId) throws QuizNotFoundException, UserNotFoundException {
        CompletableFuture<User> userFuture = userService.getUserByIdAsync(userId);
        CompletableFuture<List<Quiz>> quizzesFuture = quizService.getAllQuizzesByUserIdAsync(userId);
        return CompletableFuture.allOf(userFuture, quizzesFuture).thenApply(placeHolder ->
                UserQuizzes.builder().user(userFuture.join()).quizzes(quizzesFuture.join()).build()).join();
    }
}
