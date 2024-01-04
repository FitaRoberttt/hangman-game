package com.example.HangmanApi.repository;

import com.example.HangmanApi.model.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Integer> {

    List<Word> findByDifficulty(String difficulty);



}
