package marketplace.backend.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import marketplace.backend.exception.Error;
import marketplace.backend.exception.exceptions.offer.OfferPossessionException;

@ControllerAdvice
public class OfferControllerAdvisor {
    
    @ExceptionHandler(OfferPossessionException.class)
    public ResponseEntity<Error> emailIntegrityViolation(OfferPossessionException e) {

        Long id = e.getId();

        Error error = new Error(400, "Offer with id '" + id + "' is not in users possession.");

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }
}
