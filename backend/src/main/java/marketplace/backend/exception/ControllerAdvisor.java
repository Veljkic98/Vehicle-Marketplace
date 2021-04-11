package marketplace.backend.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import marketplace.backend.exception.user.EmailIntegrityViolationException;
import marketplace.backend.exception.user.UserNotFoundException;

@ControllerAdvice
public class ControllerAdvisor {
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> adminNotFound(UserNotFoundException e) {

        Long userId = e.getUserId();

        Error error = new Error(404, "User with id: " + userId + ", not found");

        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailIntegrityViolationException.class)
    public ResponseEntity<Error> emailIntegrityViolation(EmailIntegrityViolationException e) {

        String email = e.getEmail();

        Error error = new Error(400, "User with email: " + email + ", already exists.");

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    //TODO: Ako ne bude bilo koristeno, brisemo
    public ResponseEntity<Error> dataIntegrityViolation(DataIntegrityViolationException e) {

        Error error = new Error(400, "Integrity violation.");

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }
}
