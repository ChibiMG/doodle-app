import { Component, OnInit } from '@angular/core';
import {Participant} from "../participant";
import {Date} from "../date";
import {CurrentUserService} from "../current-user.service";
import {SondageService} from "../sondage.service";
import {ReunionService} from "../reunion.service";
import {DateService} from "../date.service";
import {Reunion} from "../reunion";
import {Sondage} from "../sondage";

@Component({
  selector: 'app-create-sondage',
  templateUrl: './create-sondage.component.html',
  styleUrls: ['./create-sondage.component.css']
})
export class CreateSondageComponent {
  intitule: string = '';
  resume: string = '';
  dates: number[];
  datesString: string;
  createur: Participant;
  reunion: Reunion;
  sondage: Sondage;

  constructor(private currentUserService: CurrentUserService, private sondageService: SondageService, private reunionService: ReunionService, private dateService: DateService) { }

  foo(intitule: string, resume: string, datesString: string) {
    console.log("ok");
    this.currentUserService.currentUser.subscribe(user => this.createur = user);

    this.reunion = new Reunion(intitule, resume);
    console.log(this.reunionService.createReunion(this.reunion).subscribe());

    let datesStringTab = datesString.split(";");
    for (let stringDate of datesStringTab) {
      let date = new Date(stringDate);
      this.dateService.createDate(date).subscribe();
      this.dates.push(date.id);
    }

    this.sondage = new Sondage(this.createur.email, this.reunion.id, this.dates)
    this.sondageService.createSondage(this.sondage).subscribe();


  }

}
