package com.impostercorp.signuptest.responses;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * TODO: convert to a simpler error response
 * Created by sayeedm on 7/4/17.
 */
public class BaseResponse {
    private String message;
    private String error;
    private List<FieldError> fieldErrors;
    private List<ObjectError> globalErrors;

    public BaseResponse(final String message) {
        super();
        this.message = message;
    }

    public BaseResponse(final String message, final String error) {
        super();
        this.message = message;
        this.error = error;
    }

    public BaseResponse(final List<FieldError> fieldErrors, final List<ObjectError> globalErrors) {
        super();
        this.fieldErrors = fieldErrors;
        this.globalErrors = globalErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(final String error) {
        this.error = error;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public List<ObjectError> getGlobalErrors() {
        return globalErrors;
    }

    public void setGlobalErrors(List<ObjectError> globalErrors) {
        this.globalErrors = globalErrors;
    }
}
