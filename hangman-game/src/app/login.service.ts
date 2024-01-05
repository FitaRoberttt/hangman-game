import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  getUserDetails(username:string){

     // Definim datele pe care dorim să le trimitem
     const requestData = { username: username };

     // Facem request-ul de tip POST către server
     return this.http.post('http://localhost:8080/user/auth/'+username, requestData);
    
  }
}
