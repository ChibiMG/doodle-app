import {Participant} from "./participant";
import {Reunion} from "./reunion";
import {Date} from "./date";

export class Sondage {
  id: number;
  createur: string;
  reunion: number;
  dates: number[];

  constructor(createur: string, reunion: number, dates: number[]) {
    this.createur = createur;
    this.reunion = reunion;
    this.dates = dates;
  }
}
