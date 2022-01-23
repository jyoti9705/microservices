package com.jyoti.webservices.restfulwebserviceswithspringboot.userService;

import com.jyoti.webservices.restfulwebserviceswithspringboot.exceptions.UserNotFoundException;
import com.jyoti.webservices.restfulwebserviceswithspringboot.model.Post;

import java.util.List;

public interface PostJPAService {

    public List<Post> getAllPostsForUser(Integer userId) throws UserNotFoundException;

    public Post getPostForUserWithPostId(Integer userId, Integer postId);

    public Post addPostForUser(Integer userId, Post post) throws UserNotFoundException;
}
