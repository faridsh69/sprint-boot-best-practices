package com.farid.Divar.Library.Resources;

public class ApiResource<T> {
  private final T data;

  public ApiResource(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }
}

