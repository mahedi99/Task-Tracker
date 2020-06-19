import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BasicAuthServiceService } from '../service/basic-auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = '1'
  password = ''
  errorMessage = 'Invalid Credentials'
  invalidLogin = false

  constructor(public router: Router, private basicAuth: BasicAuthServiceService) { }

  ngOnInit(): void {
  }

  handleLogin(){
    this.basicAuth.authenticate(this.username, this.password)
    .subscribe(
      data => {
        console.log(data);
        this.router.navigate(['admin', 'mahedi'])
      }
    )
  }
}
 