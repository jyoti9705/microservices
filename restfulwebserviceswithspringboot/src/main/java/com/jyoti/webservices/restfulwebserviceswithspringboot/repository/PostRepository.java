package com.jyoti.webservices.restfulwebserviceswithspringboot.repository;

import com.jyoti.webservices.restfulwebserviceswithspringboot.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByUser_Id(Integer id);
    Post findByIdAndUser_Id(Integer postId , Integer userId);
}
