import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  article = [{
    url: '#',
    title: 'Guidelines'
  }, {
    url: '#',
    title: 'FAQ'
  }, {
    url: '#',
    title: 'Lists'
  }, {
    url: '#',
    title: 'API'
  }, {
    url: '#',
    title: 'Security'
  }, {
    url: '#',
    title: 'Legal'
  }, {
    url: '#',
    title: 'Apply to YC'
  }, {
    url: '#',
    title: 'Contact'
  }];
  constructor() { }

  ngOnInit(): void {
  }

}
