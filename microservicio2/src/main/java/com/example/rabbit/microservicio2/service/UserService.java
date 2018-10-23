package com.example.rabbit.microservicio2.service;

import com.example.rabbit.microservicio2.domain.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getallUsers();
    User getUserById(Long id);
    void deleteUserById(Long id);
}
