import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RatingExcuteComponent } from './rating-excute.component';

describe('RatingExcuteComponent', () => {
  let component: RatingExcuteComponent;
  let fixture: ComponentFixture<RatingExcuteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RatingExcuteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RatingExcuteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
