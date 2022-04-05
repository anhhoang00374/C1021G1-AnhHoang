import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-rating-excute',
  templateUrl: './rating-excute.component.html',
  styleUrls: ['./rating-excute.component.css']
})
export class RatingExcuteComponent implements OnInit {
  @Input() value: number = 0;
  rate(value){
    this.value = value;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
