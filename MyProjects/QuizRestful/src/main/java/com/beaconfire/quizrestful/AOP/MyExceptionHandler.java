package com.beaconfire.quizrestful.AOP;

import com.beaconfire.quizrestful.domain.ErrorResponse;
import com.beaconfire.quizrestful.exception.QuizNotFoundException;
import com.beaconfire.quizrestful.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

//    @ExceptionHandler(value={Exception.class})
//    public ResponseEntity handleException(Exception e){
//        return new ResponseEntity(ErrorResponse.builder().message("Something May Wrong!").build(), HttpStatus.OK);
//    }

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e){
        return new ResponseEntity(ErrorResponse.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {QuizNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleQuizNotFoundException(QuizNotFoundException e){
        return new ResponseEntity(ErrorResponse.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }
}
