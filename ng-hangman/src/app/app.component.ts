import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { HangmanKeyboardComponent } from "./components/hangman-keyboard/hangman-keyboard.component";
import { HangmanQuestionComponent } from "./components/hangman-question/hangman-question.component";
import { HangmanDisplayComponent } from "./components/hangman-display/hangman-display.component";

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
    imports: [CommonModule, RouterOutlet,  HangmanKeyboardComponent, HangmanQuestionComponent, HangmanDisplayComponent]
})
export class AppComponent {
  [x: string]: any;
  selectedLetter: string = '';
  displayedWord: string[] = [];
  wrongGuess: boolean = false;
  wrongGuessCount: number = -1;
  MaxWrongGuesses: number = 7;
  loseSound = new Audio('../assets/sounds/loser.mp3'); 


  onLetterSelected(letter: string) {
    this.selectedLetter = letter;

    if (!this['guessWord'].includes(letter)) {
      this.wrongGuessCount++;
    }
    this['checkGameOver']();
  }


  onWordUpdated(event: Event) {
    this.displayedWord = [(event.target as HTMLInputElement).value];
  }

  onWrongGuess(wrong: boolean) {
    if (wrong) {
      this.wrongGuessCount++;
      console.log('Wrong guess count:', this.wrongGuessCount);
    }
  }
  checkGameOver() {
     if (this.wrongGuessCount >= this.MaxWrongGuesses) {
      this['gameOver'] = true;
      this.loseSound.play();
    }
  }

  resetGame() {
    location.reload();
  }
}

