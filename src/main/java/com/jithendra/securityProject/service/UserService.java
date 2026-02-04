package com.jithendra.securityProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.security.autoconfigure.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jithendra.securityProject.model.Users;
import com.jithendra.securityProject.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public Users registerUser(Users user) {
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        return userRepo.save(user);
    }
}
