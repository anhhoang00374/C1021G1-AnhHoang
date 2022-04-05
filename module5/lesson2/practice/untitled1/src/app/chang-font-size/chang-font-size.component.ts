import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-chang-font-size',
  templateUrl: './chang-font-size.component.html',
  styleUrls: ['./chang-font-size.component.css']
})
export class ChangFontSizeComponent implements OnInit {
  fontSize =  16;
  changSize(tag){
    this.fontSize = tag.value ;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
