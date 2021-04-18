package marketplace.backend.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import marketplace.backend.exception.Error;
import marketplace.backend.exception.exceptions.user.*;

@ControllerAdvice
public class UserControllerAdvisor {

    @ExceptionHandler(EmailIntegrityViolationException.class)
    public ResponseEntity<Error> emailIntegrityViolation(EmailIntegrityViolationException e) {

        String email = e.getEmail();

        Error error = new Error(400, "User with email '" + email + "' already exists.");

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailOrCompanyNameIntegrityViolationException.class)
    public ResponseEntity<Error> emailOrCompanyIntegrityViolation(EmailOrCompanyNameIntegrityViolationException e) {

        String email = e.getEmail();
        String companyName = e.getCompanyName();

        Error error = new Error(400, "User with email: '" + email + "' or company name (username): '" + companyName + "' already exists.");

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

}
