package marketplace.backend.exception.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import marketplace.backend.exception.Error;
import marketplace.backend.exception.exceptions.global.MyConstraintViolationException;
import marketplace.backend.exception.exceptions.global.MyEntityNotFoundException;
import marketplace.backend.exception.exceptions.global.UniquenessViolationException;

@ControllerAdvice
public class GlobalControllerAdvisor {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Error> dataIntegrityViolation(DataIntegrityViolationException e) {

        System.out.println("--------------------------------");
        System.out.println(e);
        Error error = new Error(400, "Data integrity error occured.");

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MyEntityNotFoundException.class)
    public ResponseEntity<Error> myEntityNotFound(MyEntityNotFoundException e) {

        String entityName = e.getEntityName();

        Long id = e.getId();

        Error error = new Error(404, entityName + " with id '" + id + "' not found.");

        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UniquenessViolationException.class)
    public ResponseEntity<Error> uniquenessViolation(UniquenessViolationException e) {

        String message = e.getMessage();

        Error error = new Error(400, message);

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MyConstraintViolationException.class)
    public ResponseEntity<Error> myConstraintViolation(MyConstraintViolationException e) {

        String prymary = e.getPrimaryEntity();

        String foreign = e.getForeignEntity();

        Long id = e.getId();

        Error error = new Error(409,
                prymary + "/s with id: '" + id + "' cannot be deleted because its connected with " + foreign.toLowerCase() + "/s.");

        return new ResponseEntity<Error>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PropertyReferenceException.class)
    public ResponseEntity<Error> invalidURLParam(PropertyReferenceException e) {

        Error error = new Error(400, "Invalid URL parameter/s");

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    public ResponseEntity<Error> authenticateError(AuthenticationCredentialsNotFoundException e) {

        Error error = new Error(403, "Not authorized.");

        return new ResponseEntity<Error>(error, HttpStatus.FORBIDDEN);
    }

}
