import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Route, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  model:any = {};
  user:any = {};

  constructor(private loginService: LoginService, private router:Router, private userService: UserService) { }

  ngOnInit(): void {
  }

  loginUser(){
    
    var username = this.model.username;

    console.log(username);

    this.loginService.getUserDetails(username).subscribe((res:any)=>{
      
      this.user = res;

      console.log(this.user.userId);
      if(this.user){
        this.userService.setUser(this.user);
        this.router.navigate(['/game']);
      }
      else{
        alert("Invalid username");
      }
      

    })

  }

}
