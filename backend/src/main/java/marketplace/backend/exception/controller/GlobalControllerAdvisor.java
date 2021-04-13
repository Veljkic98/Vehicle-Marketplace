package marketplace.backend.exception.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import marketplace.backend.exception.Error;

@ControllerAdvice
public class GlobalControllerAdvisor {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> globalException(Exception e) {

        Error error = new Error(400, "Unhandled error occured.");

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Error> dataIntegrityViolation(DataIntegrityViolationException e) {

        Error error = new Error(400, "Data integrity error occured.");

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }
    
}
