package com.example.HangmanApi.service.impl;

import com.example.HangmanApi.model.entity.User;
import com.example.HangmanApi.repository.UserRepository;
import com.example.HangmanApi.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getOrCreateUserByName(String name) {

        User existingUser = userRepository.findByName(name);

        if (existingUser != null) {
            return existingUser;
        } else {
            User newUser = new User();
            newUser.setName(name);
            userRepository.save(newUser);
            return newUser;
        }
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}
