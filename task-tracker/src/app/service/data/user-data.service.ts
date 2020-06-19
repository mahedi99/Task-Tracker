import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'src/app/admin/admin.component';
import { API_URL } from 'src/app/ap.constants';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  constructor(private http: HttpClient) { }

  retrieveAllUsers(adminname){
    let basicAuth = this.createBasicAuth()
    let header = new HttpHeaders({
      Authorization: basicAuth
    })
    return this.http.get<User[]>(`${API_URL}/admin/getUsers`, {headers : header});
  }

  createBasicAuth(){
    let username = '1'
    let password = '123'
    let basicAuth = 'Basic ' + window.btoa(username + ':' + password);
    return basicAuth;
  }

}
