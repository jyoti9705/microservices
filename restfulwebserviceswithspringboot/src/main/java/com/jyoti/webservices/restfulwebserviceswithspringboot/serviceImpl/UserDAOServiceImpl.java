package com.jyoti.webservices.restfulwebserviceswithspringboot.serviceImpl;

import com.jyoti.webservices.restfulwebserviceswithspringboot.model.User;
import com.jyoti.webservices.restfulwebserviceswithspringboot.userService.UserDaoService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOServiceImpl implements UserDaoService {

    private Integer usersCount = 2;

    private static List<User> users() {
        List<User> users = new ArrayList<>();
        LocalDate jyotiLocalDate = LocalDate.of(1997, 9, 5);
        User user1 = User.builder().id(1).name("Jyoti").birthdate(jyotiLocalDate).build();
        LocalDate abcLocalDate = LocalDate.of(1996, 1, 26);
        User user2 = User.builder().id(2).name("ABC").birthdate(abcLocalDate).build();
        users.add(user1);
        users.add(user2);
        return users;
    }

    @Override
    public List<User> getAllUsers() {
        return users();
    }



    @Override
    public User getSpecificUser(Integer id) {
        return users().stream().anyMatch(user -> id == user.getId()) ? users().stream().filter(user -> id == user.getId()).findFirst().get() : null;
    }

    @Override
    public User addUser(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users().add(user);
        return user;
    }
}
