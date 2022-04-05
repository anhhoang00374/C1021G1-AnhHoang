import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangFontSizeComponent } from './chang-font-size.component';

describe('ChangFontSizeComponent', () => {
  let component: ChangFontSizeComponent;
  let fixture: ComponentFixture<ChangFontSizeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChangFontSizeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangFontSizeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
