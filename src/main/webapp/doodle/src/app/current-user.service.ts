import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {Participant} from "./participant";

@Injectable()

export class CurrentUserService {

  private messageSource = new BehaviorSubject(null);
  currentUser = this.messageSource.asObservable();

  constructor() { }

  set(user: Participant) {
    this.messageSource.next(user);
  }

}
