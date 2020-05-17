import {Participant} from "./participant";
import {Reunion} from "./reunion";
import {Date} from "./date";

export class Sondage {
  id: number;
  createur: Participant;
  reunion: Reunion;
  dates: Date[];

  constructor(createur: Participant, reunion: Reunion, dates: Date[]) {
    this.createur = createur;
    this.reunion = reunion;
    this.dates = dates;
  }
}
