import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeSondagesComponent } from './liste-sondages.component';

describe('ListeSondagesComponent', () => {
  let component: ListeSondagesComponent;
  let fixture: ComponentFixture<ListeSondagesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListeSondagesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeSondagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
