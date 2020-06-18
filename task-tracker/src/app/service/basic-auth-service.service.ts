import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthServiceService {

  constructor() { }

  isUserLoggedIn(){
    return true
  }
}
