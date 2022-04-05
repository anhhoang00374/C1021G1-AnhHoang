import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WaytoeventComponent } from './waytoevent.component';

describe('WaytoeventComponent', () => {
  let component: WaytoeventComponent;
  let fixture: ComponentFixture<WaytoeventComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WaytoeventComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WaytoeventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
