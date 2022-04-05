import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import {Rating} from '../rating';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {
  constructor() { }
  value: number;
  ratingList: Rating[] = [{
    color: 'gray',
    value: 1
  }, {
    color: 'gray',
    value: 2
  }, {
    color: 'gray',
    value: 3
  }, {
    color: 'gray',
    value: 4
  }, {
    color: 'gray',
    value: 5
  }, {
    color: 'gray',
    value: 6
  }, {
    color: 'gray',
    value: 7
  }, {
    color: 'gray',
    value: 8
  }, {
    color: 'gray',
    value: 9
  }];
  @Output() excute = new EventEmitter();

  ngOnInit(): void {
  }
  rate(value) {
    this.value = value;
    // tslint:disable-next-line:no-shadowed-variable
    for (const item of this.ratingList){
      if (item.value <= value){
        item.color = 'yellow';
      } else {
        item.color = 'gray';
      }
    }
  }
}
