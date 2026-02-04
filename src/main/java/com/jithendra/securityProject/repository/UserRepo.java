package com.jithendra.securityProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jithendra.securityProject.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
