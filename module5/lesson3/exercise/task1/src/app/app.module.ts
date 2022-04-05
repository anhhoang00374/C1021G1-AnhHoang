import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {GreetingComponent} from './greeting/greeting.component';
import { WaytoeventComponent } from './waytoevent/waytoevent.component';

@NgModule({
  declarations: [
    AppComponent,
    GreetingComponent,
    WaytoeventComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
