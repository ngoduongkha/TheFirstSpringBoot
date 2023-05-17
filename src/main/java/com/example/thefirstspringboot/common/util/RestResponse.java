package com.example.thefirstspringboot.common.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

@Getter
@Setter
public class RestResponse<T> {

    private Integer statusCode;
    private String message;
    private Object data;

    @JsonIgnore
    private HttpStatus httpStatus;

    public RestResponse() {
        statusCode = 0;
        message = null;
        data = null;
        httpStatus = HttpStatus.OK;
    }

    public RestResponse<T> withStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public RestResponse<T> withMessage(String message) {
        this.message = message;
        return this;
    }

    public RestResponse<T> withData(T data) {
        this.data = data;
        return this;
    }

    public RestResponse<T> withDataObj(T data) {
        this.data = data;
        return this;
    }

    public RestResponse<T> withData (Collection<T> collection) {
        this.data = collection;
        return this;
    }

    public RestResponse<T> withHttpStatus (HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public ResponseEntity<RestResponse<T>> buildHttpResponseEntity () {
        return new ResponseEntity<>(this, this.httpStatus);
    }
}
