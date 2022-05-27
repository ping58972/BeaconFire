package com.beaconfire.pp_webservice_restful.AOP;

import com.beaconfire.pp_webservice_restful.domain.ErrorResponse;
import com.beaconfire.pp_webservice_restful.domain.Quiz;
import com.beaconfire.pp_webservice_restful.exception.QuizNotFoundException;
import com.beaconfire.pp_webservice_restful.exception.UserNotFoundException;
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
