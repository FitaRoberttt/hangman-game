import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(private http: HttpClient) {}

  startNewGame(difficulty: string, userId: number): Observable<any> {
    return this.http.post('http://localhost:8080/hangman/startGame/' + difficulty + '/' + userId, {});
  }

  guessLetter(gameId: number, letter: string): Observable<any> {
    return this.http.post('http://localhost:8080/hangman/guessLetter/' + gameId + '/' + letter, {});
  }
}
