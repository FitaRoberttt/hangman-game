package com.example.HangmanApi.service.impl;


import com.example.HangmanApi.model.dto.HangmanGameDto;
import com.example.HangmanApi.model.entity.HangmanGame;
import com.example.HangmanApi.model.entity.Word;
import com.example.HangmanApi.model.mapper.HangmanGameMapper;
import com.example.HangmanApi.repository.HangmanGameRepository;
import com.example.HangmanApi.service.HangmanGameService;
import com.example.HangmanApi.service.UserService;
import com.example.HangmanApi.service.WordService;
import org.springframework.stereotype.Service;



@Service
public class HangmanGameServiceImpl implements HangmanGameService {

    private final HangmanGameRepository hangmanGameRepository;
    private final WordService WordService;

    private final UserService userService;

    public HangmanGameServiceImpl(HangmanGameRepository hangmanGameRepository, WordService WordService, UserService userService) {
        this.hangmanGameRepository = hangmanGameRepository;
        this.WordService = WordService;
        this.userService = userService;
    }

    public HangmanGameDto startGame(String difficulty, Integer userId) {

        HangmanGame hangmanGame = new HangmanGame();

        Word word = WordService.getRandomWordByDifficulty(difficulty);

        hangmanGame.setWord(word);

        hangmanGame.setAttemptsLeft(7);

        hangmanGame.setGuessedWord(word.getValue().replaceAll("[a-zA-Z]", "_"));

        hangmanGame.setUser(userService.getUserById(userId));

        hangmanGameRepository.save(hangmanGame);

        return HangmanGameMapper.toDto(hangmanGame);
    }

    public HangmanGameDto guessLetter(Integer gameId, char letter) {

        HangmanGame hangmanGame = hangmanGameRepository.findById(gameId)
                .orElseThrow(() -> new IllegalArgumentException("Jocul nu a fost găsit"));

        String word = hangmanGame.getWord().getValue();
        String guessedWord = hangmanGame.getGuessedWord();
        StringBuilder newGuessedWord = new StringBuilder();

        boolean isLetterFound = false;

        for (int i = 0; i < word.length(); i++) {
            if (Character.toLowerCase(word.charAt(i)) == Character.toLowerCase(letter)) {
                newGuessedWord.append(letter);
                isLetterFound = true;
            } else {
                newGuessedWord.append(guessedWord.charAt(i));
            }
        }

        if (!isLetterFound) {
            hangmanGame.setAttemptsLeft(hangmanGame.getAttemptsLeft() - 1);
        }

        if (hangmanGame.getAttemptsLeft() == 0) {
            hangmanGame.setGameLost(true);
        }

        if (newGuessedWord.toString().toLowerCase().equals(word)) {
            hangmanGame.setGameWon(true);
        }

        hangmanGame.setGuessedWord(newGuessedWord.toString());

        hangmanGameRepository.save(hangmanGame);

        return HangmanGameMapper.toDto(hangmanGame);
    }

}
