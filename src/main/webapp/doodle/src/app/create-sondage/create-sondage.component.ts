import { Component, OnInit } from '@angular/core';
import {Participant} from "../participant";
import {Date} from "../date";
import {CurrentUserService} from "../current-user.service";
import {SondageService} from "../sondage.service";
import {Reunion} from "../reunion";
import {Sondage} from "../sondage";
import { FormBuilder, FormArray } from '@angular/forms';

@Component({
  selector: 'app-create-sondage',
  templateUrl: './create-sondage.component.html',
  styleUrls: ['./create-sondage.component.css']
})
export class CreateSondageComponent {
  createur: Participant;
  sondageForm;
  dates: {
    date: string;
  }[] = [];

  constructor(private currentUserService: CurrentUserService, private sondageService: SondageService, private formBuilder: FormBuilder) { 
    this.currentUserService.currentUser.subscribe(user => this.createur = user);
    this.sondageForm = formBuilder.group({
      intitule: '',
      resume: '',  
      datesArray: this.formBuilder.array([])
    })
  }

  onSubmit(formData) {
    let reunion = new Reunion(formData.intitule, formData.resume)
    let sondage = new Sondage(this.createur, reunion, formData.datesArray)
    console.log(sondage);
    this.sondageService.createSondage(sondage).subscribe();
  }

  get datesArray() {
    return this.sondageForm.get('datesArray') as FormArray;
  }
  
  addItem() {
    this.datesArray.push(this.formBuilder.group({
      date: ''
    }));
  }
  
  removeItem(i) {
    this.datesArray.removeAt(i);
  }

}
