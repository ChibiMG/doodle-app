import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateParticipantComponent } from './create-participant/create-participant.component';
import { CreateSondageComponent } from './create-sondage/create-sondage.component';


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
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
