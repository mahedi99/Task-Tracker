package com.mahedi.userservice.controllers;

import com.mahedi.userservice.data.User;
import com.mahedi.userservice.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @author Mahedi Hassan
 * 2020-06-03
 */

@RestController
@RequestMapping("user")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/get-users")
    public List<User> getAllUser(){
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/create-user")
    public ResponseEntity<Void> createUser(@RequestBody User user){
        User newUser = userRepository.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
