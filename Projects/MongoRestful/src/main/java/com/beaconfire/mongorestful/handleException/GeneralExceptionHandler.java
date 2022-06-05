package com.beaconfire.mongorestful.handleException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity generalException(Exception e){
        return new ResponseEntity("Uh! Something wrong.", HttpStatus.BAD_REQUEST);
    }
}
