package com.jyoti.webservices.restfulwebserviceswithspringboot.controller;

import com.jyoti.webservices.restfulwebserviceswithspringboot.exceptions.UserNotFoundException;
import com.jyoti.webservices.restfulwebserviceswithspringboot.model.Post;
import com.jyoti.webservices.restfulwebserviceswithspringboot.userService.PostJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostJPAService postJPAService;

    @GetMapping("jpa/users/{id}/posts")
    public ResponseEntity<List<Post>> getAllPostsForUser(@PathVariable Integer id) throws UserNotFoundException {
        List<Post> allPostsForUser = postJPAService.getAllPostsForUser(id);
        return ResponseEntity.ok(allPostsForUser);
    }

    @PostMapping("jpa/users/{id}/posts")
    public ResponseEntity<Post> addPostForUser(@PathVariable Integer id, @RequestBody Post post) throws UserNotFoundException {
        Post savedPost = postJPAService.addPostForUser(id, post);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).body(savedPost);
    }

    @GetMapping("jpa/users/{id}/posts/{postId}")
    public ResponseEntity<Post> getPostByPostAndUserId(@PathVariable Integer id, @PathVariable Integer postId) {
        Post postForUserWithPostId = postJPAService.getPostForUserWithPostId(id, postId);
        return ResponseEntity.ok(postForUserWithPostId);
    }
}
