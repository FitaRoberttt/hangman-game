package com.example.HangmanApi.model.dto;

public class HangmanGameDto {

    private int gameId;

    private String guessedWord;

    private int attemptsLeft;

    private Boolean gameWon;

    private Boolean gameLost;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGuessedWord() {
        return guessedWord;
    }

    public void setGuessedWord(String guessedWord) {
        this.guessedWord = guessedWord;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public void setAttemptsLeft(int attemptsLeft) {
        this.attemptsLeft = attemptsLeft;
    }

    public Boolean getGameWon() {
        return gameWon;
    }

    public void setGameWon(Boolean gameWon) {
        this.gameWon = gameWon;
    }

    public Boolean getGameLost() {
        return gameLost;
    }

    public void setGameLost(Boolean gameLost) {
        this.gameLost = gameLost;
    }



}
