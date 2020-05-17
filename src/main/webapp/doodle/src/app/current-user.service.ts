import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {Participant} from "./participant";
import {CanActivate, Router} from "@angular/router";
import {map, take} from "rxjs/operators";

@Injectable()

export class CurrentUserService implements CanActivate {

  private messageSource = new BehaviorSubject(null);
  currentUser = this.messageSource.asObservable();

  constructor(private router: Router) {}

  set(user: Participant) {
    this.messageSource.next(user);
  }

  canActivate() {
    return this.currentUser.pipe(
      take(1),
      map(user => {
        if (user) {
          return true;
        }
        else {
          return this.router.parseUrl("/login");
        }
      })
    )
  }

}
