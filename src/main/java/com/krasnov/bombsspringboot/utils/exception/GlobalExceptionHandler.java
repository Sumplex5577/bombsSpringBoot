package com.krasnov.bombsspringboot.utils.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
       // ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Bomb with such id was not found =" + request.getParameter("id"), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    
    }

    @ExceptionHandler(ResourceWasDeletedException.class)
    protected ResponseEntity<MyGlobalExceptionHandler> handleDeleteException() {
        return new ResponseEntity<>(new MyGlobalExceptionHandler("This bomb was deleted"), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ResourceNotExistException.class)
    protected ResponseEntity<MyGlobalExceptionHandler> handlerNotExistException() {
        return new ResponseEntity<>(new MyGlobalExceptionHandler("This bomb does not exist"), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(new MyGlobalExceptionHandler("This bomb was deleted"), HttpStatus.NOT_FOUND);

    }


    @Data
    @AllArgsConstructor
    private static class MyGlobalExceptionHandler {
        private String message;
    }

}
