import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListeSondagesComponent} from "./liste-sondages/liste-sondages.component";
import {CreateParticipantComponent} from "./create-participant/create-participant.component";
import {CreateSondageComponent} from "./create-sondage/create-sondage.component";
import {CurrentUserService} from "./current-user.service";
import {HomeComponent} from "./home/home.component";


const routes: Routes = [
  {path: "sondages", component: ListeSondagesComponent, canActivate: [CurrentUserService]},
  {path: "login", component: CreateParticipantComponent},
  {path: "sondages/add", component: CreateSondageComponent, canActivate: [CurrentUserService]},
  {path: "", component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
