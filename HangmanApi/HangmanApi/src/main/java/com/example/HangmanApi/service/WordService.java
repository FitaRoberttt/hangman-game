package com.example.HangmanApi.service;

import com.example.HangmanApi.model.entity.Word;

public interface WordService {
    Word getRandomWordByDifficulty(String difficulty);

}
