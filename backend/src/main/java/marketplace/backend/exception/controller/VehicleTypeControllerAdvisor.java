package marketplace.backend.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import marketplace.backend.exception.Error;
import marketplace.backend.exception.exceptions.vehicleType.ModelReferenceConstraintViolationException;

@ControllerAdvice
public class VehicleTypeControllerAdvisor {

    @ExceptionHandler(ModelReferenceConstraintViolationException.class)
    public ResponseEntity<Error> modelReferenceConstraintViolation(ModelReferenceConstraintViolationException e) {

        Long id = e.getId();

        String type = e.getType();

        Error error = new Error(400, type + " with id '" + id + "' is still referenced from model.");

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }
    
}
