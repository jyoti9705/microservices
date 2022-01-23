package com.jyoti.webservices.restfulwebserviceswithspringboot.serviceImpl;

import com.jyoti.webservices.restfulwebserviceswithspringboot.model.User;
import com.jyoti.webservices.restfulwebserviceswithspringboot.repository.UserRepository;
import com.jyoti.webservices.restfulwebserviceswithspringboot.userService.UserJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserJPAServiceImpl implements UserJPAService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getSpecificUser(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.isPresent() ? userOptional.get() : null;
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
