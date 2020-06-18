import { Component, OnInit } from '@angular/core';
import { BasicAuthServiceService } from '../service/basic-auth-service.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(public basicAuthService: BasicAuthServiceService) { }

  ngOnInit(): void {
  }

}
