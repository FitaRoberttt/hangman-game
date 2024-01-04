package com.example.HangmanApi.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "hangman_games")
public class HangmanGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "word_id")
    private Word word;

    @Column(name = "guessed_word")
    private String guessedWord; // Cuvântul ghicit până acum

    @Column(name = "attempts_left")
    private int attemptsLeft;

    @Column(name = "game_won")
    private boolean gameWon;

    @Column(name = "game_lost")
    private boolean gameLost;


}