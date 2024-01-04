package com.example.HangmanApi.controller;

import com.example.HangmanApi.model.entity.User;
import com.example.HangmanApi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/auth/{name}")
    public ResponseEntity<User> loginOrCreateUser(@PathVariable String name){

        User user = userService.getOrCreateUserByName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

}