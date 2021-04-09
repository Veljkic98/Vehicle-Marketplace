package marketplace.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import marketplace.backend.exception.user.UserNotFoundException;

@ControllerAdvice
public class ControllerAdvisor {
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> adminNotFound(UserNotFoundException e) {

        Long userId = e.getUserId();

        Error error = new Error(7, "User with id: " + userId + ", not found");

        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }
}
