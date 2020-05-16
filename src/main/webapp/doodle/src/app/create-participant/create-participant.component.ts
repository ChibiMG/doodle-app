import { Component, OnInit } from '@angular/core';
import {Participant} from "../participant";
import {ParticipantService} from "../participant-service.service";

@Component({
  selector: 'app-create-participant',
  templateUrl: './create-participant.component.html',
  styleUrls: ['./create-participant.component.css']
})
export class CreateParticipantComponent {
  name: string = '';
  firstname: string = '';
  email: string = '';
  participant: Participant;

  constructor(private participantsService: ParticipantService) { }

  foo(name: string, fistname: string, email: string) {
    console.log("ok");
    this.participant = new Participant(name, fistname, email);
    this.participantsService.createParticipant(this.participant).subscribe();
  }

}
