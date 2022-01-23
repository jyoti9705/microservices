package com.jyoti.webservices.restfulwebserviceswithspringboot.serviceImpl;

import com.jyoti.webservices.restfulwebserviceswithspringboot.exceptions.PostNotFoundException;
import com.jyoti.webservices.restfulwebserviceswithspringboot.exceptions.PostNotSavedException;
import com.jyoti.webservices.restfulwebserviceswithspringboot.exceptions.UserNotFoundException;
import com.jyoti.webservices.restfulwebserviceswithspringboot.model.Post;
import com.jyoti.webservices.restfulwebserviceswithspringboot.model.User;
import com.jyoti.webservices.restfulwebserviceswithspringboot.repository.PostRepository;
import com.jyoti.webservices.restfulwebserviceswithspringboot.repository.UserRepository;
import com.jyoti.webservices.restfulwebserviceswithspringboot.userService.PostJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostJPAServiceImpl implements PostJPAService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public List<Post> getAllPostsForUser(Integer userId) throws UserNotFoundException {
        List<Post> byUser_id = postRepository.findByUser_Id(userId);
        if (byUser_id == null) {
            throw new UserNotFoundException("User with userId : " + userId + " was not found");
        }
        return byUser_id;
    }

    @Override
    public Post getPostForUserWithPostId(Integer userId, Integer postId) {
        Post byIdAndUser_id = postRepository.findByIdAndUser_Id(postId, userId);
        if (byIdAndUser_id == null) {
            throw new PostNotFoundException("Post with userId : " + userId + " and postId " + postId + " was not found");
        }
        return byIdAndUser_id;
    }

    @Override
    public Post addPostForUser(Integer userId, Post post) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User with id " + userId + " was not found");
        }
        User user = optionalUser.get();
        Post postToSave = Post.builder().description("My First post").user(user).build();
        Post postSaved = postRepository.save(postToSave);
        if(postSaved==null){
            throw new PostNotSavedException("Post for user with userId : "+userId+" was not saved");
        }
        return postSaved;
    }
}
