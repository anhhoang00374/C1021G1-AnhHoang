import {Component} from '@angular/core';
@Component({
  templateUrl: 'greeting.component.html',
  selector : 'app-greeting',
  styleUrls: ['greeting.component.css']
})

export class GreetingComponent {
  forgot = false;
  changeDisplay(){
    this.forgot = !this.forgot;
  }
}
