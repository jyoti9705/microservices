package com.jyoti.webservices.restfulwebserviceswithspringboot.userService;

import com.jyoti.webservices.restfulwebserviceswithspringboot.model.User;

import java.util.List;

public interface UserDaoService {

    public List<User> getAllUsers();
    public User addUser(User user);
    public User getSpecificUser(Integer id);
}
