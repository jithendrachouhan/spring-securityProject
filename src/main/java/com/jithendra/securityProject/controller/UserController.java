package com.jithendra.securityProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jithendra.securityProject.model.Users;
import com.jithendra.securityProject.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user) {
        System.out.println("user registration request received for: " + user.getUsername());
        return service.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Users user) {
        return service.verify(user);
    }

}