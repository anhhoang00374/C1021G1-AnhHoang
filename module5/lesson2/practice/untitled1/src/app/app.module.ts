import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { TestComponent } from './test/test.component';
import { PersonComponent } from './person/person.component';
import { ChangFontSizeComponent } from './chang-font-size/chang-font-size.component';
import { ShowPetComponent } from './show-pet/show-pet.component';


@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    PersonComponent,
    ChangFontSizeComponent,
    ShowPetComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
