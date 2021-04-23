package marketplace.backend.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import marketplace.backend.exception.Error;
import marketplace.backend.exception.exceptions.file.ImageBadRequestException;

@ControllerAdvice
public class ImageControllerAdvisor {

    @ExceptionHandler(ImageBadRequestException.class)
    public ResponseEntity<Error> dataIntegrityViolation(ImageBadRequestException e) {

        Error error = new Error(400, "Image is invalid.");

        return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
    }
    
}
