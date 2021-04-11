package marketplace.backend.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import marketplace.backend.exception.user.EmailIntegrityViolationException;
import marketplace.backend.exception.user.EmailOrCompanyNameIntegrityViolationException;
import marketplace.backend.exception.user.UserNotFoundException;
import marketplace.backend.exception.user.UserOffersConstraintViolationException;

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

    @ExceptionHandler(EmailOrCompanyNameIntegrityViolationException.class)
    public ResponseEntity<Error> emailOrCompanyIntegrityViolation(EmailOrCompanyNameIntegrityViolationException e) {

        String email = e.getEmail();
        String companyName = e.getCompanyName();

        Error error = new Error(400, "User with email: '" + email + "', or company name (username): '" + companyName + "', already exists.");

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserOffersConstraintViolationException.class)
    public ResponseEntity<Error> UserOffersConstraintViolation(UserOffersConstraintViolationException e) {

        Long id = e.getId();

        Error error = new Error(409, "User with id: '" + id + "' cannot be deleted because he has offers.");

        return new ResponseEntity<Error>(error, HttpStatus.CONFLICT);
    }

}
