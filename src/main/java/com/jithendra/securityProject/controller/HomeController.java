package com.jithendra.securityProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HomeController {

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(HttpServletRequest request) {
        return new ResponseEntity<>("hello my friends, how are you?!!!!!!  " + request.getSession().getId(), HttpStatus.OK);
    }

}
