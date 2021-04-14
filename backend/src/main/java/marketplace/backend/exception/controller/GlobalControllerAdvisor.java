package marketplace.backend.exception.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import marketplace.backend.exception.Error;
import marketplace.backend.exception.exceptions.global.MyEntityNotFoundException;
import marketplace.backend.exception.exceptions.global.UniquenessViolationException;

@ControllerAdvice
public class GlobalControllerAdvisor {

    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<Error> globalException(Exception e) {

    //     Error error = new Error(400, "Unhandled error occured.");

    //     return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    // }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Error> dataIntegrityViolation(DataIntegrityViolationException e) {

        Error error = new Error(400, "Data integrity error occured.");

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MyEntityNotFoundException.class)
    public ResponseEntity<Error> MyEntityNotFound(MyEntityNotFoundException e) {

        String message = e.getMessage();

        Error error = new Error(404, message);

        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UniquenessViolationException.class)
    public ResponseEntity<Error> uniquenessViolation(UniquenessViolationException e) {

        String message = e.getMessage();

        Error error = new Error(400, message);

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }
    
}
