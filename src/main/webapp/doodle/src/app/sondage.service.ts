import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Sondage} from "./sondage";

const  httpOptions = {
  headers: new HttpHeaders ( {'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class SondageService {

  private sondagesURL = 'http://localhost:8080/rest/sondages/';

  constructor(private http: HttpClient) { }

  getListSondages(): Observable<any> {
    return this.http.get(this.sondagesURL);
  }
  getSondageById(id: number): Observable<any> {
    return this.http.get(this.sondagesURL + id);
  }

  createSondage(sondage: Sondage): Observable<any>{
    return this.http.post(this.sondagesURL, sondage);
  }

  deleteSondage(id: number): Observable<any>{
    return this.http.delete(this.sondagesURL + id);
  }
}
