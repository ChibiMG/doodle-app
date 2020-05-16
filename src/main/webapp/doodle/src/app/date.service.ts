import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Date} from "./date";

const  httpOptions = {
  headers: new HttpHeaders ( {'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class DateService {

  private datesURL = 'http://localhost:8080/rest/dates';
  private dateByIdURL = 'http://localhost:8080/rest/date/';

  constructor(private http: HttpClient) { }

  getListDates(): Observable<any> {
    return this.http.get(this.datesURL);
  }
  geDateById(id: string): Observable<any> {
    return this.http.get(this.dateByIdURL + id);
  }

  createDate(date: Date): Observable<any>{
    return this.http.post(this.datesURL, date);
  }

}
