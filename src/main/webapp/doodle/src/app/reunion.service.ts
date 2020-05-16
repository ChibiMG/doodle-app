import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Participant} from "./participant";
import {Reunion} from "./reunion";

const  httpOptions = {
  headers: new HttpHeaders ( {'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ReunionService {

  private reunionsURL = 'http://localhost:8080/rest/reunions';
  private reunionByIdURL = 'http://localhost:8080/rest/reunions/';

  constructor(private http: HttpClient) { }

  getListReunion(): Observable<any> {
    return this.http.get(this.reunionsURL);
  }
  getReunionById(id: string): Observable<any> {
    return this.http.get(this.reunionByIdURL + id);
  }

  createReunion(reunion: Reunion): Observable<any>{
    return this.http.post(this.reunionsURL, reunion);
  }
}
