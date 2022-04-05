import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  articleHeaderList = [{
    url: '#',
    title : 'Hacker News'
  },{
    url: '#',
    title : 'New'
  },{
    url: '#',
    title : 'Past'
  },{
    url: '#',
    title : 'Comments'
  },{
    url: '#',
    title : 'ask'
  },{
    url: '#',
    title : 'Show'
  },{
    url: '#',
    title : 'Jobs'
  },
    {
      url: '#',
      title : 'Submit'
    }];
  constructor() { }

  ngOnInit(): void {
  }

}
