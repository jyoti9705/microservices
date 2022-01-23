package com.jyoti.webservices.restfulwebserviceswithspringboot.userService;

import com.jyoti.webservices.restfulwebserviceswithspringboot.model.User;

import java.util.List;

public interface UserJPAService {
    public List<User> getAllUsers();
    public User addUser(User user);
    public User getSpecificUser(Integer id);
    public void deleteById(Integer id);
}
