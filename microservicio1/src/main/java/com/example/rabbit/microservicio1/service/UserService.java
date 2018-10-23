package com.example.rabbit.microservicio1.service;

import com.example.rabbit.microservicio1.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getallUsers();
    User getUserById(Long id);
    void deleteUserById(Long id);
    String enviarUsuarioAServicio2(Long id);
}
