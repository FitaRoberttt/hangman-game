package com.example.HangmanApi.service.impl;

import com.example.HangmanApi.model.entity.Word;
import com.example.HangmanApi.repository.WordRepository;
import com.example.HangmanApi.service.WordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class WordServiceImplTest {

    @Mock
    private WordRepository wordRepository;

    private WordService wordService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        wordService = new WordServiceImpl(wordRepository);
    }

    @Test
    void testGetRandomWordByDifficulty() {
        // Arrange
        String difficulty = "easy";
        List<Word> wordList = new ArrayList<>();

        Word word1 = new Word();
        word1.setDifficulty(difficulty);
        wordList.add(word1);


        // Simulăm comportamentul repository-ului
        when(wordRepository.findByDifficulty(difficulty)).thenReturn(wordList);

        // Act
        Word randomWord = wordService.getRandomWordByDifficulty(difficulty);

        // Assert
        assertEquals(difficulty, randomWord.getDifficulty());
    }
}
