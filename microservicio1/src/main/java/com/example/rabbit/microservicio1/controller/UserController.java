package com.example.rabbit.microservicio1.controller;

import com.example.rabbit.microservicio1.domain.User;
import com.example.rabbit.microservicio1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/servicio1")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/usuarios")
    public List<User> getUsers(){
        return userService.getallUsers();
    };

    @GetMapping("/usuarios/{id}")
    public User getUsersById(@PathVariable(name = "id") final Long id){
        return userService.getUserById(id);
    };

    @PostMapping("/usuarios")
    public User postUser(@Valid @RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/usuarios/{id}")
    public String deleteUsersById(@PathVariable(name = "id") final Long id){
        userService.deleteUserById(id);
        return "Usuario Borrado";
    };

    @GetMapping("/usuarios/{id}/send")
    public String sendUsersById(@PathVariable(name = "id") final Long id){
        return userService.enviarUsuarioAServicio2(id);
    };
}
