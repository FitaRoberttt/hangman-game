package com.example.HangmanApi.service;

import com.example.HangmanApi.model.entity.User;

public interface UserService {

    User getOrCreateUserByName(String name);

    User getUserById(Integer userId);
}
