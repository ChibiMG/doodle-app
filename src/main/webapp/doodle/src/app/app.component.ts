import { Component } from '@angular/core';
import {CurrentUserService} from "./current-user.service";
import {Participant} from "./participant";
import MD5 from "crypto-js/md5";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Doodle';
  hash: string;
  currentUser: Participant;

  constructor(private currentUserService: CurrentUserService, private router: Router) {
    currentUserService.currentUser.subscribe(user => {
      if (user) {
        this.hash = MD5(user.email);
      }
      this.currentUser = user;
    })
  }

  logout(){
    this.currentUserService.set(null);
    this.router.navigate(["/"]);
  }

}
