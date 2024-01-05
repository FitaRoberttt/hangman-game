import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { GameComponent } from './game/game.component';
import { HangmanKeyboardComponent } from './hangman-keyboard/hangman-keyboard.component';
import { HangmanDisplayComponent } from './hangman-display/hangman-display.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    GameComponent,
    HangmanKeyboardComponent,
    HangmanDisplayComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
