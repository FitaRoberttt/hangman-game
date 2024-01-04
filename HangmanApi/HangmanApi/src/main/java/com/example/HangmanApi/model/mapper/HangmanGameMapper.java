package com.example.HangmanApi.model.mapper;

import com.example.HangmanApi.model.dto.HangmanGameDto;
import com.example.HangmanApi.model.entity.HangmanGame;

public class HangmanGameMapper {


    public static HangmanGameDto toDto(HangmanGame hangmanGame) {
        HangmanGameDto hangmanGameDto = new HangmanGameDto();
        hangmanGameDto.setGameId(hangmanGame.getGameId() != null ? hangmanGame.getGameId().intValue() : 0);
        hangmanGameDto.setGuessedWord(hangmanGame.getGuessedWord());
        hangmanGameDto.setAttemptsLeft(hangmanGame.getAttemptsLeft());
        hangmanGameDto.setGameWon(hangmanGame.isGameWon());
        hangmanGameDto.setGameLost(hangmanGame.isGameLost());
        return hangmanGameDto;
    }

    public static HangmanGame toEntity(HangmanGameDto hangmanGameDto) {
        HangmanGame hangmanGame = new HangmanGame();
        hangmanGame.setGameId(hangmanGameDto.getGameId());
        hangmanGame.setGuessedWord(hangmanGameDto.getGuessedWord());
        hangmanGame.setAttemptsLeft(hangmanGameDto.getAttemptsLeft());
        hangmanGame.setGameWon(hangmanGameDto.getGameWon());
        hangmanGame.setGameLost(hangmanGameDto.getGameLost());

        return hangmanGame;
    }


}
