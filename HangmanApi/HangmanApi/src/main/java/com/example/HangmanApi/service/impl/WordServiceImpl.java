package com.example.HangmanApi.service.impl;

import com.example.HangmanApi.model.entity.Word;
import com.example.HangmanApi.repository.WordRepository;
import com.example.HangmanApi.service.WordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;

    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word getRandomWordByDifficulty(String difficulty) {

        List<Word> wordList = wordRepository.findByDifficulty(difficulty);

        int randomIndex = (int) (Math.random() * wordList.size());

        Word randomWord = wordList.get(randomIndex);

        return randomWord;

    }
}
