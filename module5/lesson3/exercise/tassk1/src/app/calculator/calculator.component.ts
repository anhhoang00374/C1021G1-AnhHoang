import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  num1: number;
  num2: number;
  oparetor: string;
  result: string;
  calculate(){
    switch (this.oparetor){
      case ('+'):
        this.result =  (this.num1 * 1 + this.num2 * 1) + '';
        break;
      case ('-'):
        this.result = 'Result is: ' + (this.num1 - this.num2);
        break;
      case ('*'):
        this.result = 'Result is: ' + (this.num1 * this.num2);
        break;
      case ('/'):
        if (this.num2 === 0){
          this.result = 'num2 must be not 0' ;
         } else { this.result = 'Result is: ' + (this.num1 / this.num2); }
        break;
    }
  }
  constructor() { }

  ngOnInit(): void {
  }

}
