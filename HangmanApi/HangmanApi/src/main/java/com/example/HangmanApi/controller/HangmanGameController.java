package com.example.HangmanApi.controller;

import com.example.HangmanApi.model.dto.HangmanGameDto;
import com.example.HangmanApi.model.entity.HangmanGame;
import com.example.HangmanApi.service.HangmanGameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hangman")
public class HangmanGameController {

    private final HangmanGameService hangmanGameService;

    public HangmanGameController(HangmanGameService hangmanGameService) {
        this.hangmanGameService = hangmanGameService;
    }

    @PostMapping("/startGame/{difficulty}/{userId}")
    public ResponseEntity<HangmanGameDto> startGame(@PathVariable String difficulty, @PathVariable Integer userId) {

        HangmanGameDto hangmanGameDto = hangmanGameService.startGame(difficulty, userId);
        return new ResponseEntity<>(hangmanGameDto, HttpStatus.OK);

    }

    @PostMapping("/guessLetter/{gameId}/{letter}")
    public ResponseEntity<HangmanGameDto> guessLetter(@PathVariable Integer gameId, @PathVariable char letter) {

        HangmanGameDto hangmanGameDto = hangmanGameService.guessLetter(gameId, letter);
        return new ResponseEntity<>(hangmanGameDto, HttpStatus.OK);

    }



}
