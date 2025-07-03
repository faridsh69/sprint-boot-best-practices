package com.farid.Divar.Library.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler{

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException ex){
    HttpStatus status = HttpStatus.NOT_FOUND;
    String message = ex.getMessage() != null ? ex.getMessage() : "Entity not found";
    ErrorResponse response = new ErrorResponse(message, status.value());

    return new ResponseEntity<>(response, status);
  }

  @ExceptionHandler(NoResourceFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFound(NoResourceFoundException e){
    HttpStatus status = HttpStatus.NOT_FOUND;
    ErrorResponse response = new ErrorResponse(e.getMessage(), status.value());

    return new ResponseEntity<>(response, status);
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<ErrorResponse> handleMethodNotAllowed(HttpRequestMethodNotSupportedException e){
    HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
    ErrorResponse response = new ErrorResponse(e.getMessage(), status.value());

    return new ResponseEntity<>(response, status);
  }

  // @ExceptionHandler(MethodArgumentNotValidException.class)
  // public ResponseEntity<ErrorResponse>
  // handleValidationErrors(MethodArgumentNotValidException ex)
  // {
  // String errorMsg = ex.getBindingResult().getAllErrors().stream()
  // .map(error -> error.getDefaultMessage())
  // .collect(Collectors.joining("; "));
  // return new ResponseEntity<>(new ErrorResponse("VALIDATION_FAILED",
  // errorMsg),
  // HttpStatus.BAD_REQUEST);
  // }

//   @ExceptionHandler(MethodArgumentNotValidException.class)
// public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
//     Map<String, String> errors = new HashMap<>();
//     ex.getBindingResult().getFieldErrors().forEach(error ->
//         errors.put(error.getField(), error.getDefaultMessage())
//     );
//     return ResponseEntity.badRequest().body(errors);
// }


  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<ErrorResponse> handleException(ResponseStatusException ex){
    HttpStatusCode status = ex.getStatusCode();
    ErrorResponse response = new ErrorResponse(ex.getMessage(), status.value());

    return new ResponseEntity<>(response, status);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception ex){
    HttpStatusCode status = HttpStatus.INTERNAL_SERVER_ERROR;
    ErrorResponse response = new ErrorResponse(ex.getMessage(), status.value());

    return new ResponseEntity<>(response, status);
  }
}
