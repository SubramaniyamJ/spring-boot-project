package com.example.springapphasc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapphasc.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
    
}
