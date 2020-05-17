import { Component, OnInit } from '@angular/core';
import {CurrentUserService} from "../current-user.service";
import {Participant} from "../participant";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  currentUser: Participant;

  constructor(private currentUserService: CurrentUserService) {
    currentUserService.currentUser.subscribe(user =>{
      this.currentUser = user;
    });
  }

  ngOnInit(): void {
  }

}
