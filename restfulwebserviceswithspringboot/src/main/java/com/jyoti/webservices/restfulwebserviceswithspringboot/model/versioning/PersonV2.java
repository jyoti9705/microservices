package com.jyoti.webservices.restfulwebserviceswithspringboot.model.versioning;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PersonV2 {
    public String firstName;
    public String lastName;
}
