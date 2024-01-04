package com.example.HangmanApi.repository;

import com.example.HangmanApi.model.entity.HangmanGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HangmanGameRepository extends JpaRepository<HangmanGame, Integer> {

}
