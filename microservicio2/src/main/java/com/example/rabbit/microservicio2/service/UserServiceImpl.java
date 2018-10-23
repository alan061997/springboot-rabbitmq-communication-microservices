package com.example.rabbit.microservicio2.service;

import com.example.rabbit.microservicio2.domain.User;
import com.example.rabbit.microservicio2.exception.ResourceNotFoundException;
import com.example.rabbit.microservicio2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getallUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
