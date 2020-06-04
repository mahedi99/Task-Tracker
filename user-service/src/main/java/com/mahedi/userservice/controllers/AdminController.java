package com.mahedi.userservice.controllers;

import com.mahedi.userservice.data.User;
import com.mahedi.userservice.repositories.UserRepository;
import com.mahedi.userservice.repositories.UserRoleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

/**
 * @author Mahedi Hassan
 * 2020-06-03
 */

@RestController
@RequestMapping("admin")
public class AdminController {


    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    public AdminController(UserRepository userRepository, UserRoleRepository userRoleRepository){
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    /**
     * Find users from persistence storage based on role Role.USER
     * @return the list of {@code User}
     */
    @GetMapping(path = "/getUsers")
    public Collection<User> getAllUser(){
        return userRepository.findAllUsers();
    }

    /**
     * Find users from persistence storage based on role Role.ADMIN
     * @return the list of {@code User}
     */
    @GetMapping(path = "/getAdmins")
    public Collection<User> getAllAdmins(){
        return userRepository.findAllAdmins();
    }

    /**
     * Create a new user including Admin and User
     * @return the list of {@code User}
     */
    @PostMapping(path = "/createUser")
    public ResponseEntity<Void> createUser(@RequestBody User user){
        User newUser = userRepository.save(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
