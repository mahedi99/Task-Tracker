import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = '123'
  password = ''
  errorMessage = 'Invalid Credentials'
  invalidLogin = false

  constructor(public router: Router) { }

  ngOnInit(): void {
  }

  handleLogin(){
    console.log(this.username)
    if(this.username === '123' && this.password==='123'){
      this.router.navigate(['admin', 'mahedi'])
    }
    else{
      this.invalidLogin = true
    }
  }
}