import { Component } from '@angular/core';
import MD5 from "crypto-js/md5";
import {CurrentUserService} from "./current-user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Doodle';
  currentUser = null;
  hash: string = '';

  constructor(private currentUserService: CurrentUserService) {
    currentUserService.currentUser.subscribe(user => {
      this.currentUser = user;
      if (user != null) {
        this.hash = MD5(user.email)
      }
    });
  }

}
