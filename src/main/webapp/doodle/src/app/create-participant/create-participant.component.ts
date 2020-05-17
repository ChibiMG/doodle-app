import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatFormFieldControl } from "@angular/material/form-field";

import {Participant} from "../participant";
import {ParticipantService} from "../participant-service.service";
import {CurrentUserService} from "../current-user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-participant',
  templateUrl: './create-participant.component.html',
  styleUrls: ['./create-participant.component.css'],
})
export class CreateParticipantComponent {
  participantForm;

  constructor(private participantsService: ParticipantService, private currentUserService: CurrentUserService, private formBuilder: FormBuilder, private router: Router) {
    this.participantForm = formBuilder.group({
      prenom: '',
      nom: '',
      email: ''
    })
  }

  onSubmit(formData) {
    this.participantsService.createParticipant(formData).subscribe(participant => {
      this.currentUserService.set(participant);
      this.router.navigate(["/sondages"]);
    });
  }

}
