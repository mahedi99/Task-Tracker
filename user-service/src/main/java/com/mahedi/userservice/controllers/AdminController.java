package com.mahedi.userservice.controllers;

import com.mahedi.userservice.data.User;
import com.mahedi.userservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * @author Mahedi Hassan
 * 2020-06-03
 */

@RestController
@RequestMapping("admin")
public class AdminController {


    private UserService userService;

    public AdminController(UserService userService){
        this.userService = userService;
    }

    /**
     * Find users from persistence storage based on role Role.USER
     * @return the list of {@code User}
     */
    @GetMapping(path = "/getUsers")
    public ResponseEntity getAllUser(){
        try {
            return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest()
                    .body("BAD REQUEST");
        }
    }

    /**
     * Find users from persistence storage based on role Role.ADMIN
     * @return the list of {@code User}
     */
    @GetMapping(path = "/getAdmins")
    public ResponseEntity getAllAdmins(){
        try {
            return new ResponseEntity(userService.getAllAdmins(), HttpStatus.OK);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest()
                    .body("BAD REQUEST");
        }
    }

    /**
     * Create a new user including Admin and User
     * @return the list of {@code User}
     */
    @PostMapping(path = "/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user){
        User newUser;
        try {
            newUser = userService.createUser(user);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{" + newUser.getId() + "}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        try {
            userService.updateUser(user);
        }catch (RuntimeException e){
            return new ResponseEntity(user, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

}
