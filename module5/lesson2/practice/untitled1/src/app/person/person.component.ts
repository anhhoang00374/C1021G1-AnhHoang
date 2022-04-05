import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {
  @Input() name: string;
  @Input() age: number;
  @Output() myClick = new EventEmitter();
  userName = '';
  password = '';
  constructor() { }

  ngOnInit(): void {
  }

  add() {
    this.myClick.emit();
  }

  submit(signIn) {
    console.log(signIn);
  }
}
