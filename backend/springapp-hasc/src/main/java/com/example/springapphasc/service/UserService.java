package com.example.springapphasc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapphasc.model.User;
import com.example.springapphasc.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    public final UserRepo userRepo;
    
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    
    public User createUser(User user){
        return userRepo.save(user);
    }


    public User getUserById(int userId){
        return userRepo.findById(userId).orElse(null);
    }

    public User updateUserById(int userId, User user){
        User id = userRepo.findById(userId).orElse(null);
        if(id != null){
            id.setUsername(user.getUsername());
            id.setEmail(user.getEmail());
            id.setPassword(user.getPassword());
        }
        return userRepo.save(id);
    }

    public Boolean deleteUserById(int userId){
        userRepo.deleteById(userId);
        return true;
    }
}
