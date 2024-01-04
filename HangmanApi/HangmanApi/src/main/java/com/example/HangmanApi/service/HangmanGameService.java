package com.example.HangmanApi.service;

import com.example.HangmanApi.model.dto.HangmanGameDto;
import com.example.HangmanApi.model.entity.HangmanGame;

public interface HangmanGameService {

    HangmanGameDto startGame(String difficulty, Integer userId);

    HangmanGameDto guessLetter(Integer gameId, char letter);


}
