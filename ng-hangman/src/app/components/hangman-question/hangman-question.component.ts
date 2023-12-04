import { Component, OnInit, Input, OnChanges, SimpleChanges, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HangmanKeyboardComponent } from "../hangman-keyboard/hangman-keyboard.component";

@Component({
    selector: 'app-hangman-question',
    standalone: true,
    templateUrl: './hangman-question.component.html',
    styleUrls: ['./hangman-question.component.scss'],
    imports: [CommonModule, HangmanKeyboardComponent]
})
export class HangmanQuestionComponent implements OnInit, OnChanges {
  @Output() wrongGuess = new EventEmitter<boolean>();
  wordListEasy: string[] = ['Caine', 'Pisica']; 
  wordListMedium: string[] = ['Bucuresti', 'Budapesta']; 
  wordListHard: string[] = ['Sternocleidomastoidian', 'Velociraptor']; 
  selectedWord: string = '';
  displayedWord: string[] = [];
  wonMessage: string = '';
  guessedLetters: Set<string> = new Set<string>();
  @Input()
  selectedLetter: string= '';
  difficulty: 'easy' | 'medium' | 'hard' = 'easy';
  winSound = new Audio('../assets/sounds/congratulations.mp3'); 

  ngOnInit() {
    this.selectRandomWord();
    this.initializeDisplayedWord();
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['selectedLetter']) {
      this.guessLetter(this.selectedLetter);
    }
  }
  selectRandomWord() {
    let wordList;
    if (this.difficulty === 'easy') {
      wordList = this.wordListEasy;
    } else if (this.difficulty === 'medium') {
      wordList = this.wordListMedium;
    } else {
      wordList = this.wordListHard;
    }

    const randomIndex = Math.floor(Math.random() * wordList.length);
    this.selectedWord = wordList[randomIndex].toLowerCase();
  }

  setDifficulty(difficulty: 'easy' | 'medium' | 'hard') {
    this.difficulty = difficulty;
    this.selectRandomWord();
    this.initializeDisplayedWord();
  }

  initializeDisplayedWord() {
    this.displayedWord = Array(this.selectedWord.length).fill('_');
  }

  guessLetter(letter: string) {
    let ok = false;
    letter = letter.toLowerCase();

    if (this.guessedLetters.has(letter)) {
      return;
    }

    this.guessedLetters.add(letter);

    if (this.selectedWord.includes(letter)) {
      for (let i = 0; i < this.selectedWord.length; i++) {
        if (this.selectedWord[i] === letter) {
          this.displayedWord[i] = letter;
          ok = true;
        }
      }
    }

    if (!ok) {
      this.wrongGuess.emit(true);
    }


    if (this.displayedWord.join('') === this.selectedWord && this.selectedWord.length > 0) {
      this.winSound.play();
      this.wonMessage = 'Congratulations! You won the game!';
    }
  }
  checkLetter(letter: string) {
    if (this.selectedWord.includes(letter)) {
    } else {
      this.wrongGuess.emit(true);
    }
  }
}
