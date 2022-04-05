import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from "@angular/forms";
import { AppComponent } from './app.component';
import { NgifComponent } from './ngif/ngif.component';

@NgModule({
  declarations: [
    AppComponent,
    NgifComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
