import { Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
  value: string;
  arr: string[] = ['hoa', 'trai cay'];
  checkDisplay: boolean;
  score = 0;
  add(){
    this.arr.push(this.value);
    this.checkDisplay = !this.checkDisplay;
  }
  constructor() { }

  ngOnInit(): void {
  }

  remove(item: string) {
    this.arr.forEach(((value1, index1) => {
      if (item === value1){
       this.arr.splice(index1, 1);
      }
      })

    );
  }

  crement() {
    this.score = this.score + 1;
  }
}
