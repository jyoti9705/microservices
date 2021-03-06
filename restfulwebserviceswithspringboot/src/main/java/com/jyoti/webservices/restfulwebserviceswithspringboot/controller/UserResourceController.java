package com.jyoti.webservices.restfulwebserviceswithspringboot.controller;

import com.jyoti.webservices.restfulwebserviceswithspringboot.exceptions.UserNotFoundException;
import com.jyoti.webservices.restfulwebserviceswithspringboot.model.User;
import com.jyoti.webservices.restfulwebserviceswithspringboot.userService.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResourceController {

    @Autowired
    private UserDaoService userDaoService;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userDaoService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getUserById(@PathVariable Integer id) throws UserNotFoundException {
        User user = userDaoService.getSpecificUser(id);
        if (user == null) {
            throw new UserNotFoundException("User with id = " + id + " was not found");
        }
        EntityModel entityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(linkBuilder.withRel("all-users"));
        Link linkToSelf = linkTo(methodOn(this.getClass()).getUserById(id)).withSelfRel();
        entityModel.add(linkToSelf);
        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User addedUser = userDaoService.addUser(user);
        if (addedUser == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).body(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) throws UserNotFoundException {
        User userDeleted = userDaoService.deleteById(id);
        if (userDeleted == null) {
            throw new UserNotFoundException("User with id = " + id + " was not found");
        }
        return;
    }


}
