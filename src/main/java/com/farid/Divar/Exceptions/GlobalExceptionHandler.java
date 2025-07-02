package com.farid.Divar.Exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException ex) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    String message = ex.getMessage() != null ? ex.getMessage() : "Entity not found";
    ErrorResponse response = new ErrorResponse(message, status.value());

    return new ResponseEntity<>(response, status);
  }

  @ExceptionHandler(NoResourceFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFound(NoResourceFoundException e) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    ErrorResponse response = new ErrorResponse(e.getMessage(), status.value());

    return new ResponseEntity<>(response, status);
  }


  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<ErrorResponse> handleMethodNotAllowed(HttpRequestMethodNotSupportedException e) {
    HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
    ErrorResponse response = new ErrorResponse(e.getMessage(), status.value());

    return new ResponseEntity<>(response, status);
  }
}
