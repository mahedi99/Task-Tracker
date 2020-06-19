package com.mahedi.userservice.controllers;

import com.mahedi.userservice.data.AuthBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mahedi Hassan
 * 2020-04-28
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthController {


    @GetMapping(path = "/basicauth")
    public AuthBean helloWorldBean(){
        return new AuthBean("You Are Authenticated");
//        throw new RuntimeException("Some Error");
    }

}
