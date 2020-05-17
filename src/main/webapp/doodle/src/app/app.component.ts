import { Component } from '@angular/core';
import {CurrentUserService} from "./current-user.service";
import {Participant} from "./participant";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Doodle';
  currentUser: Participant;

  constructor(private currentUserService: CurrentUserService) {
    currentUserService.currentUser.subscribe(user =>{
      this.currentUser = user;
    });
  }
}
