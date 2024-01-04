package com.example.HangmanApi.service.impl;

import com.example.HangmanApi.model.dto.HangmanGameDto;
import com.example.HangmanApi.model.entity.HangmanGame;
import com.example.HangmanApi.model.entity.Word;
import com.example.HangmanApi.repository.HangmanGameRepository;
import com.example.HangmanApi.service.UserService;
import com.example.HangmanApi.service.WordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HangmanGameServiceImplTest {

    @Mock
    private HangmanGameRepository hangmanGameRepository;

    @Mock
    private WordService wordService;

    @Mock
    private UserService userService;

    @InjectMocks
    private HangmanGameServiceImpl hangmanGameService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void startGame() {
        // Aranjare
        String difficulty = "easy";
        Integer userId = 1;

        Word mockWord = new Word();
        mockWord.setValue("test");
        when(wordService.getRandomWordByDifficulty(difficulty)).thenReturn(mockWord);

        when(userService.getUserById(userId)).thenReturn(null);

        HangmanGame savedHangmanGame = new HangmanGame();
        when(hangmanGameRepository.save(any(HangmanGame.class))).thenReturn(savedHangmanGame);

        // Acțiune
        HangmanGameDto hangmanGameDto = hangmanGameService.startGame(difficulty, userId);

        // Asertare
        assertNotNull(hangmanGameDto);
        assertEquals("____", hangmanGameDto.getGuessedWord());
        assertEquals(7, hangmanGameDto.getAttemptsLeft());
        assertFalse(hangmanGameDto.getGameLost());
        assertFalse(hangmanGameDto.getGameWon());

        // Verificare că metoda save a fost apelată
        verify(hangmanGameRepository, times(1)).save(any(HangmanGame.class));
    }


}
