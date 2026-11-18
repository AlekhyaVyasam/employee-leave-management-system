package com.alekhya.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeNotFound(
            EmployeeNotFoundException ex) {

        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );

        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateEmail(
            DuplicateEmailException ex) {

        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                ex.getMessage()
        );

        return new ResponseEntity<>(
                response,
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex) {

        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getBindingResult()
                        .getFieldError()
                        .getDefaultMessage()
        );

        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST);
    }
}