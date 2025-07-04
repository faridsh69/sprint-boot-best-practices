package com.farid.Divar.Library.Exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

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

    //  @ExceptionHandler(MethodArgumentNotValidException.class)
//  public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
//    Map<String, String> errors = new HashMap<>();
//    ex.getBindingResult().getFieldErrors().forEach(error ->
//            errors.put(error.getField(), error.getDefaultMessage())
//    );
//    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//  }

//  @ExceptionHandler(ConstraintViolationException.class) // This will needed if we need validation inside controller
//  public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
//    HttpStatus status = HttpStatus.BAD_REQUEST;
//
//    List<ValidationError> validations = ex.getConstraintViolations().stream()
//      .map(violation -> new ValidationError(
//              violation.getPropertyPath().toString(),
//              violation.getMessage()
//      ))
//      .toList();
//    ErrorResponse response = new ErrorResponse("Validation failed", status.value(), validations);
//
//    return new ResponseEntity<>(response, status);
//  }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        List<ValidationError> validations = ex.getBindingResult().getFieldErrors().stream()
                .map(validation -> new ValidationError(
                        validation.getField(),
                        validation.getDefaultMessage()
                ))
                .toList();

        ErrorResponse response = new ErrorResponse("Validation failed", status.value(), validations);

        return new ResponseEntity<>(response, status);

    }


    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleException(ResponseStatusException ex) {
        HttpStatusCode status = ex.getStatusCode();
        ErrorResponse response = new ErrorResponse(ex.getMessage(), status.value());

        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        HttpStatusCode status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse response = new ErrorResponse(ex.getMessage(), status.value());

        return new ResponseEntity<>(response, status);
    }
}
