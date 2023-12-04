import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgFor } from '@angular/common';
import { HangmanKeyboardComponent } from "../hangman-keyboard/hangman-keyboard.component";
import AOS from 'aos';

@Component({
  selector: 'app-hangman-display',
  standalone: true,
  templateUrl: './hangman-display.component.html',
  styleUrl: './hangman-display.component.scss',
  imports: [CommonModule,
    NgFor, HangmanKeyboardComponent]
})

export class HangmanDisplayComponent implements OnChanges, OnInit {
  
  ngOnInit(): void {
    AOS.init();
  }
  
  @Input()
  displayedWord: string[] = [];
  @Input()
  wrongGuess: number = 0;
  lostMessage: string = "";
  loseSound = new Audio('../assets/sounds/loser.mp3'); 

  hangmanDisplay: string[] = [
    "assets/images/poza0.jpg",
    "assets/images/poza1.jpg",
    "assets/images/poza2.jpg",
    "assets/images/poza3.jpg",
    "assets/images/poza4.jpg",
    "assets/images/poza5.jpg",
    "assets/images/poza6.jpg",
    "assets/images/poza7.jpg",
  ];
  hangmanImage: any = this.hangmanDisplay[0];
  currentPictureIndex: number = 0;
  gameStartedNow: boolean = true;

  ngOnChanges(changes: SimpleChanges) {
    if (changes['wrongGuess'] && changes['wrongGuess'].currentValue !== 0) {
      this.changePicture();
    }
  }

  changePicture() {
    this.updatePicture();
  }

  updatePicture() {
    if (this.gameStartedNow) {
      this.gameStartedNow = false;
    }
    else {
      this.currentPictureIndex++;
    }
    if (this.currentPictureIndex >= this.hangmanDisplay.length - 1) {
      this.currentPictureIndex = this.hangmanDisplay.length - 1;
      this.loseSound.play();
      this.lostMessage = "You lost!";
    }
    this.hangmanImage = this.hangmanDisplay[this.currentPictureIndex];
  }
}
