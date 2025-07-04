package com.farid.Divar.Library.Exceptions;

import java.util.List;

public record ErrorResponse(
        String message,
        int status,
        List<ValidationError> validations
) {
    public ErrorResponse(String message, int status) {
        this(message, status, null);
    }
}

