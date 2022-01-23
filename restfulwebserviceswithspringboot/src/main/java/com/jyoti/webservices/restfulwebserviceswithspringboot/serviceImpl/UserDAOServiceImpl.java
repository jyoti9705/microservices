package com.jyoti.webservices.restfulwebserviceswithspringboot.serviceImpl;

import com.jyoti.webservices.restfulwebserviceswithspringboot.model.User;
import com.jyoti.webservices.restfulwebserviceswithspringboot.userService.UserDaoService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDAOServiceImpl implements UserDaoService {
    private static List<User> users = new ArrayList<>();

    private Integer usersCount = 2;

    static {
        LocalDate jyotiLocalDate = LocalDate.of(1997, 9, 5);
        User user1 = User.builder().id(1).name("Jyoti").birthdate(jyotiLocalDate).build();
        LocalDate abcLocalDate = LocalDate.of(1996, 1, 26);
        User user2 = User.builder().id(2).name("ABC").birthdate(abcLocalDate).build();
        users.add(user1);
        users.add(user2);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }


    @Override
    public User getSpecificUser(Integer id) {
        return users.stream().anyMatch(user -> id == user.getId()) ? users.stream().filter(user -> id == user.getId()).findFirst().get() : null;
    }

    @Override
    public User deleteById(Integer id) {
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            if (user.getId() == id) {
                userIterator.remove();
                return user;
            }
        }
        return null;
    }

    @Override
    public User addUser(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        System.out.println(user);
        return user;
    }
}
