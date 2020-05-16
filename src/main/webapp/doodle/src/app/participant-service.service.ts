import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Participant} from "./participant";

const  httpOptions = {
  headers: new HttpHeaders ( {'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ParticipantService {

  private participantsURL = 'http://localhost:8080/rest/participants';
  private participantByIdURL = 'http://localhost:8080/rest/participants/';

  constructor(private http: HttpClient) { }

  getListParticipants(): Observable<any> {
    return this.http.get(this.participantsURL);
  }
  getParticipantById(id: string): Observable<any> {
    return this.http.get(this.participantByIdURL + id);
  }

  createParticipant(participant: Participant): Observable<any>{
    return this.http.post(this.participantsURL, participant);
  }
}
