import { Component } from '@angular/core';
import { GameService } from '../game.service';
import { HangmanKeyboardComponent } from '../hangman-keyboard/hangman-keyboard.component';
import { UserService } from '../user.service';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrl: './game.component.css',
})
export class GameComponent {

  
  difficulty: 'easy' | 'medium' | 'hard' = 'easy';
  game: any;
  displayedWord: string[] = [];
  gameId: any;
  wrongGuessCount: any;
  attemptsLeft: any;
  public gameMessage: string = '';
  user: any;
  

  constructor(private gameService: GameService, private userService: UserService) { }

  ngOnInit(): void {
    this.user = this.userService.getUser(); // get the user from the service
  }

  setDifficulty(difficulty: 'easy' | 'medium' | 'hard') {
    this.difficulty = difficulty;
  }

  startNewGame() {

    this.gameService.startNewGame(this.difficulty, this.user.userId).subscribe(
      (response: any) => {
        this.game = response;
        console.log('', this.game);
        this.gameId = this.game.gameId;
        this.displayedWord = this.game.guessedWord.split('');
        this.wrongGuessCount = 0;
        this.attemptsLeft = this.game.attemptsLeft;
      },     
      (error) => {
        console.error('Error starting a new game:', error);
      }
    );
  }
  
  guessLetter(letter: string) {

    console.log('Guessing letter:', letter);
    console.log('Game ID:', this.gameId);
    this.gameService.guessLetter(this.gameId, letter).subscribe(
      (response: any) => {
        this.game = response;
        this.displayedWord = this.game.guessedWord.split('');

        if(this.attemptsLeft > this.game.attemptsLeft)
          this.wrongGuessCount++;
        this.attemptsLeft = this.game.attemptsLeft;

        console.log('Game:', this.game);
        if (this.game.gameWon == true)
              this.gameMessage = 'Congratulations! You won the game.';

        if (this.game.gameLost == true) 
              this.gameMessage = 'Sorry, you lost the game.';
          
      },     
      (error) => {
        console.error('Error guessing letter:', error);
      }
    );
  }


}
