import { Component, EventEmitter, Input, Output } from '@angular/core';


@Component({
  selector: 'app-hangman-keyboard',
  templateUrl: './hangman-keyboard.component.html',
  styleUrl: './hangman-keyboard.component.scss'
})
export class HangmanKeyboardComponent {
  @Output() letterSelected = new EventEmitter<string>();
  pressedKeys: string[] = [];
  

  letters: string[] = ["Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
    "A", "S", "D", "F", "G", "H", "J", "K", "L",
    "Z", "X", "C", "V", "B", "N", "M"];
  key: string = '';
  letter: string = '';
  i: any;

  selectLetter(letter: string) {
    this.pressedKeys.push(letter);
    this.letterSelected.emit(letter);
  }
} 
