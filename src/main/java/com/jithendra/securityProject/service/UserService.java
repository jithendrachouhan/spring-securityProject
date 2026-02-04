package com.jithendra.securityProject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jithendra.securityProject.model.Users;
import com.jithendra.securityProject.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    public Users registerUser(Users user) {
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return "User verified successfully";    
        } 
        return "Invalid user credentials, please try again.";
    }
}
