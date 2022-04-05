import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-count-down',
  templateUrl: './count-down.component.html',
  styleUrls: ['./count-down.component.css']
})
export class CountDownComponent implements OnInit {
  currentValue = 15;
  countDown() {
    // @ts-ignore
    if (this.currentValue > 0) {
      this.currentValue = this.currentValue - 1;
      console.log(this.currentValue);
    }
  }
    startCountDown(){
    // @ts-ignore
    setInterval(this.countDown(), 1000);
    }
    stopContDown(){
    // @ts-ignore
      clearInterval(this.countDown());
      this.currentValue = 15;
    }
    resetCountDown(){
  // @ts-ignore
      clearInterval(this.countDown());
      this.currentValue = 15;
}
    constructor() { }

  ngOnInit(): void {
  }

}
