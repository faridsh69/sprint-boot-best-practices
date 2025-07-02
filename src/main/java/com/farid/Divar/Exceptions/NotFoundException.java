package com.farid.Divar.Exceptions;

public class NotFoundException extends RuntimeException {
  public NotFoundException(Integer id) {
    super("Could not find entity " + id);
  }
}
