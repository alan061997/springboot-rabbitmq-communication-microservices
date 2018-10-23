package com.example.rabbit.microservicio1.service;

import com.example.rabbit.microservicio1.domain.User;
import com.example.rabbit.microservicio1.event.EventDispatcher;
import com.example.rabbit.microservicio1.exception.ResourceNotFoundException;
import com.example.rabbit.microservicio1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private EventDispatcher eventDispatcher;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EventDispatcher eventDispatcher) {
        this.userRepository = userRepository;
        this.eventDispatcher = eventDispatcher;
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

    @Override
    public String enviarUsuarioAServicio2(Long id) {
        User usuarioASerMandadoAlServicio2 = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
        eventDispatcher.send(usuarioASerMandadoAlServicio2);
        return "Usuario enviado = [ " + usuarioASerMandadoAlServicio2.toString() + " ]";
    }
}
