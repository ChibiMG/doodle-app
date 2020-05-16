import { Component, OnInit } from '@angular/core';
import {Participant} from "../participant";
import {Date} from "../date";
import {CurrentUserService} from "../current-user.service";
import {SondageService} from "../sondage.service";
import {Reunion} from "../reunion";
import {Sondage} from "../sondage";
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-create-sondage',
  templateUrl: './create-sondage.component.html',
  styleUrls: ['./create-sondage.component.css']
})
export class CreateSondageComponent {
  createur: Participant;
  sondageForm;

  constructor(private currentUserService: CurrentUserService, private sondageService: SondageService, private formBuilder: FormBuilder) { 
    this.currentUserService.currentUser.subscribe(user => this.createur = user);
    this.sondageForm = formBuilder.group({
      intitule: '',
      resume: '',
      datesString: ''
    })
  }

  onSubmit(formData) {
    let reunion = new Reunion(formData.intitule, formData.resume)
    let dates = []
    let datesStringTab = formData.datesString.split(";");
    for (let stringDate of datesStringTab) {
      let date = new Date(stringDate);
      dates.push(date);
    }
    let sondage = new Sondage(this.createur, reunion, dates)
    console.log(sondage);
    this.sondageService.createSondage(sondage);
  }

}
