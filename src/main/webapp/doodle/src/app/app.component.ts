import { Component } from '@angular/core';
import {CurrentUserService} from "./current-user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Doodle';
  currentUser: Boolean = false;

  constructor(private currentUserService: CurrentUserService) {
    currentUserService.currentUser.subscribe(user =>{
      this.currentUser = (user != null);
      console.log(this.currentUser == true);
      console.log(user);
    });
  }

}
