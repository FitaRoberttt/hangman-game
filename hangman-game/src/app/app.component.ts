import { Component } from '@angular/core';
import { HangmanKeyboardComponent } from './hangman-keyboard/hangman-keyboard.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'hangman-game';
}
