package com.example.HangmanApi.controller;


import com.example.HangmanApi.model.entity.Word;
import com.example.HangmanApi.service.WordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/word")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }
    //get random word by difficulty

    @GetMapping("/{difficulty}")
    public ResponseEntity<Word> getRandomWordByDifficulty(@PathVariable String difficulty) {

        Word word = wordService.getRandomWordByDifficulty(difficulty);
        return new ResponseEntity<>(word, HttpStatus.OK);

    }


}
