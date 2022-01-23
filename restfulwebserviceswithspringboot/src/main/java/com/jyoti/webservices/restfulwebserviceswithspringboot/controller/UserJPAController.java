package com.jyoti.webservices.restfulwebserviceswithspringboot.controller;

import com.jyoti.webservices.restfulwebserviceswithspringboot.exceptions.UserNotFoundException;
import com.jyoti.webservices.restfulwebserviceswithspringboot.model.User;
import com.jyoti.webservices.restfulwebserviceswithspringboot.userService.UserJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJPAController {
    @Autowired
    UserJPAService userJPAService;

    @GetMapping("jpa/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userJPAService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("jpa/users/{id}")
    public EntityModel<User> getUserById(@PathVariable int id) throws UserNotFoundException {
        User user = userJPAService.getSpecificUser(id);
        if (user == null) {
            throw new UserNotFoundException("User with id = " + id + " was not found");
        }
        EntityModel entityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(UserJPAController.class).getAllUsers());
        entityModel.add(linkBuilder.withRel("all-users"));
        Link link= linkTo(methodOn(UserJPAController.class).getUserById(id)).withSelfRel();
        entityModel.add(link);
        return entityModel;
    }

    @PostMapping("jpa/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User addedUser = userJPAService.addUser(user);
        if (addedUser == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).body(user);
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable Integer id) throws UserNotFoundException {
        userJPAService.deleteById(id);
    }
}
