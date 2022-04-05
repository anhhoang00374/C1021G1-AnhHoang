import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ngif',
  templateUrl: './ngif.component.html',
  styleUrls: ['./ngif.component.css']
})
export class NgifComponent implements OnInit {

  name:string = "";
  arr: string[] =["hoa","cay","la"];
  check: boolean= true ;
  addWord(): void{
    // @ts-ignore
    this.arr.push(name);
  }
  constructor() { }

  ngOnInit(): void {

  }

}
