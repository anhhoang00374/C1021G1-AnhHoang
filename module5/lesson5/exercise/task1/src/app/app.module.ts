import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RatingComponent } from './rating/rating.component';
import { RatingExcuteComponent } from './rating-excute/rating-excute.component';

@NgModule({
  declarations: [
    AppComponent,
    RatingComponent,
    RatingExcuteComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
