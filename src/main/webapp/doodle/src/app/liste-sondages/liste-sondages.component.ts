import { Component, OnInit } from '@angular/core';
import {SondageService} from "../sondage.service";
import {Sondage} from "../sondage";

@Component({
  selector: 'app-liste-sondages',
  templateUrl: './liste-sondages.component.html',
  styleUrls: ['./liste-sondages.component.css']
})
export class ListeSondagesComponent implements OnInit {
  sondages: Sondage[];
  displayedColumns = ["intitule", "resume", "participer", "reponses", "supprimer"]

  constructor(private sondageService: SondageService) {}

  ngOnInit() {
    this.getSondages()
  }

  deleteSondage(id: number) {
    this.sondageService.deleteSondage(id).subscribe(
      () => this.getSondages()
    );
  }

  getSondages() {
    this.sondageService.getListSondages().subscribe( sondages => {
      this.sondages = sondages;
    });
  }

}
