package com.jyoti.webservices.restfulwebserviceswithspringboot.repository;

import com.jyoti.webservices.restfulwebserviceswithspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
