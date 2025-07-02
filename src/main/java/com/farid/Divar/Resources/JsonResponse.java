package com.farid.Divar.Resources;

public class JsonResponse<T> {
    private final T data;

    public JsonResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}

