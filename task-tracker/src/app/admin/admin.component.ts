import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserDataService } from '../service/data/user-data.service';


export class User{
  constructor(
    public id: number, 
    public firstname: string,
    public lastname: string,
    public dateofbirth: Date,
    public username: string,
    public password: string,
    public role: Role
    ){
  }
}

export class Role{
  constructor(
    public id: number,
    public role: string){
  }
}

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {


  users: User[]

  constructor(private route: ActivatedRoute, private userData: UserDataService) { }

  ngOnInit(): void {
    console.log(this.route.snapshot.params['name'])
    this.userData.retrieveAllUsers('mahedi').subscribe()
  }

  addUser(){

  }

  updateUser(id){

  }

  deleteUser(id){

  }

}
