import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  arr = [{name: 'a', age: 1}, {name: 'b', age: 2}];
  title = 'untitled1';
}
