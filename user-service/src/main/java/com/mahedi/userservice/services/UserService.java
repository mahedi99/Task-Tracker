package com.mahedi.userservice.services;

import com.mahedi.userservice.data.User;
import com.mahedi.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Mahedi Hassan
 * 2020-06-06
 */

@Service
public class UserService {

    public UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Collection<User> getAllAdmins() throws RuntimeException{
        return userRepository.findAllAdmins();
    }

    public Collection<User> getAllUsers() throws RuntimeException{
        return userRepository.findAllUsers();
    }

    public User createUser(User user) throws RuntimeException {
        var tmpUser = userRepository.findByUsername(user.getUsername());
        tmpUser.ifPresent((u) -> {
            throw new RuntimeException("User Already Exist : " + u.getUsername());
        });
        return userRepository.save(user);
    }


    public void updateUser(User user) throws RuntimeException {
        var tmpUser = userRepository.findByUsername(user.getUsername());
        tmpUser.orElseThrow(() -> {
            throw new RuntimeException("User Doesn't Exist : " + user.getUsername());
        });
        tmpUser.ifPresent((u) ->{
            u.setDateofbirth(user.getDateofbirth());
            u.setFirstname(user.getFirstname());
            u.setLastname(user.getLastname());
            u.setPassword(user.getPassword());
            userRepository.save(u);
        });
    }
}


















