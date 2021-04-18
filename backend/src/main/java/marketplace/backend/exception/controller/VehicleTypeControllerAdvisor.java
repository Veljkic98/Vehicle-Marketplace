package marketplace.backend.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import marketplace.backend.exception.Error;
import marketplace.backend.exception.exceptions.vehicleType.ModelReferenceTypeConstraintViolationException;

@ControllerAdvice
public class VehicleTypeControllerAdvisor {

    @ExceptionHandler(ModelReferenceTypeConstraintViolationException.class)
    public ResponseEntity<Error> modelReferenceTypeConstraintViolation(ModelReferenceTypeConstraintViolationException e) {

        Long id = e.getId();

        Error error = new Error(400, "Vehicle type with id '" + id + "' is still referenced from model.");

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }
    
}
