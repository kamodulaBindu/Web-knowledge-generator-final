import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username: string;

  constructor(private router:Router) { }

  ngOnInit() {
   // localStorage.setItem('username', 'Expert');
    console.log(localStorage.getItem('username'));

    this.username = this.readLocalStorageValue('username');
  }

  logout(){
    localStorage.setItem('username', undefined);
    localStorage.setItem('password', undefined);
    this.router.navigate([""]);
  }

  readLocalStorageValue(username) {
    return localStorage.getItem(username);
}
}
