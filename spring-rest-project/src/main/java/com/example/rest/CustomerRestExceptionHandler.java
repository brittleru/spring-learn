package com.example.rest;

import com.example.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    // add an exception handler for CustomerNotFoundException
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException e) {
        // create CustomerErrorResponse
        CustomerErrorResponse errorResponse = new CustomerErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage(),
                    System.currentTimeMillis()
                );

        // return ResponseEntity (error goes as body, and status as status :-)
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // add another exception handler... to catch for any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception e) {
        // create CustomerErrorResponse
        CustomerErrorResponse errorResponse = new CustomerErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                System.currentTimeMillis()
        );

        // return ResponseEntity (error goes as body, and status as status :-)
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
