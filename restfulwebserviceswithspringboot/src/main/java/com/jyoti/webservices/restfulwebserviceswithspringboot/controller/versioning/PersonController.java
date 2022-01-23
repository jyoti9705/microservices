package com.jyoti.webservices.restfulwebserviceswithspringboot.controller.versioning;

import com.jyoti.webservices.restfulwebserviceswithspringboot.model.versioning.PersonV1;
import com.jyoti.webservices.restfulwebserviceswithspringboot.model.versioning.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    //Versioning using URL
    @GetMapping("person/v1")
    public PersonV1 getPersonV1() {
        return PersonV1.builder().name("Bob Charlie").build();
    }

    //Versioning using URL
    @GetMapping("person/v2")
    public PersonV2 getPersonV2() {
        return PersonV2.builder().firstName("Bob").lastName("Charlie").build();
    }

    //Versioning using Parameter
    @GetMapping(value = "person/param", params = "version=1")
    public PersonV1 getPersonV1Param() {
        return PersonV1.builder().name("Bob Charlie").build();
    }

    //Versioning using paramter
    @GetMapping(value = "person/param", params = "version=2")
    public PersonV2 getPersonV2Param() {
        return PersonV2.builder().firstName("Bob").lastName("Charlie").build();
    }

   /* //Versioning using headers
    @GetMapping(value = "person/headers", headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2PHeaders() {
        return PersonV2.builder().firstName("Bob").lastName("Charlie").build();
    }

    //Versioning using headers
    @GetMapping(value = "person/headers", headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1PHeaders() {
        return PersonV1.builder().name("Bob Charlie").build();
    }


    //Versioning using produces/Content Negotiation
    @GetMapping(value = "person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonV2PProduces() {
        return PersonV2.builder().firstName("Bob").lastName("Charlie").build();
    }

    //Versioning using produces/Content Negotiation
    @GetMapping(value = "person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonV1Produces() {
        return PersonV1.builder().name("Bob Charlie").build();
    }*/


}
