import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { LoginServiceService } from '../service/login-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  // constructor with router, loginService injection
  constructor(private router: Router, private _loginService:LoginServiceService) { }

  // variables to bind form controls
  username: string;
  password: string;

  // variable to hold the result from api
  result: boolean;

  // onInit
  ngOnInit() {
  }

  // login function
 login() : void {
   console.log(this.username);
   console.log(this.password);
   // call service method to authenticate domain expert's username and password

   if(this.username == "expert"){
   if( this.password == "root123")
   {
     // set username and password in localStorage for session
     localStorage.setItem('username', this.username);
     localStorage.setItem('password', this.password);
     // if user is authenticated, navigate to domain expert data population page
     this.router.navigate(["domainexpert"]);
     }
     else {
   // if user is not authenticated, set this result to true
   this.result=true;
   }
   }
   else{
   this.result=true;
   }
   }
   }
