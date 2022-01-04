package com.jyoti.webservices.restfulwebserviceswithspringboot.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ExceptionResponse {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
