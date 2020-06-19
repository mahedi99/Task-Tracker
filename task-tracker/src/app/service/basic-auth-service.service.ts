import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {map} from 'rxjs/operators'
import { API_URL } from '../ap.constants';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthServiceService {

  constructor(private http: HttpClient) { }

  isUserLoggedIn(){
    let user = sessionStorage.getItem('auth')
    return !(user === null)
  }

  authenticate(username, password){
    let basicAuth = 'Basic ' + window.btoa(username + ':' + password);
    let header = new HttpHeaders({
      Authorization: basicAuth
    })
    return this.http.get<BasicAuthBean>(
      `${API_URL}/basicauth`, 
      {headers : header}).pipe(
        map(
          data => {
            sessionStorage.setItem('auth', username);
            return data;
          },
          error => {
            console.log(error)
          }
        )
      ); 
  }
}

export class BasicAuthBean{
  constructor(public message: string){

  }
}