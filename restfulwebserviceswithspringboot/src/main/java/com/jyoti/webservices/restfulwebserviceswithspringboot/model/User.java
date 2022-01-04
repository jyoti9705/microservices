package com.jyoti.webservices.restfulwebserviceswithspringboot.model;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class User {
    private Integer id;
    private String name;
    private LocalDate birthdate;
}
