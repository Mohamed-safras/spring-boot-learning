package org.acentura.springbootlearning.Exceptions;

import java.util.Map;

public class ErrorResponse {
    private String errorType;
    private Map<String, String> errors;

    public ErrorResponse(String errorType, Map<String, String> errors) {
        this.errorType = errorType;
        this.errors = errors;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
