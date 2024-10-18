package com.Assignment.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrorResponse>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ValidationErrorResponse> errors = new ArrayList<>();

        // Loop through the field errors and create custom error messages
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            String field = fieldError.getField();
            Object rejectedValue = fieldError.getRejectedValue();
            String message = fieldError.getDefaultMessage();  // Default validation message

            // Add a custom error response for each field error
            errors.add(new ValidationErrorResponse(field, rejectedValue, message));
        }

        // Return the list of errors with HTTP 400 (Bad Request) status
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
