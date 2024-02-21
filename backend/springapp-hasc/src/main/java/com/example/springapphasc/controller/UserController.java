package com.example.springapphasc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapphasc.model.User;
import com.example.springapphasc.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/quickfix")
public class UserController {
    
    @Autowired
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/user")
    public User createUser(@RequestBody User user){      
        return userService.createUser(user);
    }
    

    @GetMapping("/getuser/{userId}")
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/update/{userId}")
    public User upadateUserById(@PathVariable int userId, @RequestBody User user) {
        return userService.updateUserById(userId, user);
    }

    @DeleteMapping("/delete/{userId}")
    public boolean deleteUserById(int userId){
        return userService.deleteUserById(userId);
    }
}
