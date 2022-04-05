import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-waytoevent',
  templateUrl: './waytoevent.component.html',
  styleUrls: ['./waytoevent.component.css']
})
export class WaytoeventComponent implements OnInit {
  name = '';
  check: boolean;
  constructor() { }

  ngOnInit(): void {
  }
}
