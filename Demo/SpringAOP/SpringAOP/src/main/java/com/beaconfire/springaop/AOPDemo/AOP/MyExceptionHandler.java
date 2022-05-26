package com.beaconfire.springaop.AOPDemo.AOP;

import com.beaconfire.springaop.AOPDemo.exception.DemoNotFoundException;
import com.beaconfire.springaop.AOPDemo.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity handleException(Exception e){
        return new ResponseEntity(ErrorResponse.builder().message("Different Message").build(), HttpStatus.OK);
    }

    @ExceptionHandler(value = {DemoNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleDemoNotFoundException(DemoNotFoundException e){
        return new ResponseEntity(ErrorResponse.builder().message(e.getMessage()).build(), HttpStatus.OK);
    }

}
