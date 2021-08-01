package com.psg.autocomplete.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Karanjot Singh
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException e) {
        List<String> result = e.getConstraintViolations()
                .stream()
                .map(p -> p.getPropertyPath() + ": " + p.getMessage())
                .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
