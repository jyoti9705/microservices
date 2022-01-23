package com.jyoti.webservices.restfulwebserviceswithspringboot.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("SomeBeanFilter")
public class SomeBean {
    public String value1;
    public String value2;
    @JsonIgnore
    public String value3;


}
