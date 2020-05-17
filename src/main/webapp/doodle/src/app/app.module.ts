import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatCardModule } from "@angular/material/card";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { MatButtonModule } from "@angular/material/button";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateParticipantComponent } from './create-participant/create-participant.component';
import { CreateSondageComponent } from './create-sondage/create-sondage.component';
import {ParticipantService} from "./participant-service.service";
import {CurrentUserService} from "./current-user.service";
import {ReunionService} from "./reunion.service";
import {DateService} from "./date.service";
import {SondageService} from "./sondage.service";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    CreateParticipantComponent,
    CreateSondageComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ],
  providers: [
    ParticipantService,
    CurrentUserService,
    ReunionService,
    DateService,
    SondageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
