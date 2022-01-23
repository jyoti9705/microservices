package com.jyoti.webservices.restfulwebserviceswithspringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class PostNotSavedException extends RuntimeException {
    public PostNotSavedException(String s) {
        super(s);
    }
}
