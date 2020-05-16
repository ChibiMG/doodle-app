import {Sondage} from "./sondage";
import {Date} from "./date";

export class Reunion {
  id: number;
  intitule: string;
  resume: string;
  dateReunion: Date;
  sondage: Sondage;

  constructor(intitule: string, resume: string) {
    this.intitule = intitule;
    this.resume = resume;
  }
}
