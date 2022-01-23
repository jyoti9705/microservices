package com.jyoti.webservices.restfulwebserviceswithspringboot.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static java.util.stream.Collectors.joining;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        LocalDateTime localDateTime = LocalDateTime.now();
        ExceptionResponse exceptionResponse = new ExceptionResponse(localDateTime, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({UserNotFoundException.class})
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
        LocalDateTime localDateTime = LocalDateTime.now();
        ExceptionResponse exceptionResponse = new ExceptionResponse(localDateTime, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({PostNotFoundException.class})
    public final ResponseEntity<Object> handlePostNotFoundException(Exception ex, WebRequest request) {
        LocalDateTime localDateTime = LocalDateTime.now();
        ExceptionResponse exceptionResponse = new ExceptionResponse(localDateTime, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostNotSavedException.class)
    public final ResponseEntity<Object> handlePostNotSavedException(Exception ex, WebRequest webRequest) {
        LocalDateTime localDateTime = LocalDateTime.now();
        ExceptionResponse exceptionResponse = new ExceptionResponse(localDateTime, ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LocalDateTime localDateTime = LocalDateTime.now();
        ExceptionResponse exceptionResponse = new ExceptionResponse(localDateTime, "Validation Failed", ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(joining(" , ")));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
