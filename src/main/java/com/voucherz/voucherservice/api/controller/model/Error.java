package com.voucherz.voucherservice.api.controller.model;

public class Error {
    private final String field;
    private final String message;

    public Error(String field, String message) {
        this.message = message;
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }
}
