import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSondageComponent } from './create-sondage.component';

describe('CreateSondageComponent', () => {
  let component: CreateSondageComponent;
  let fixture: ComponentFixture<CreateSondageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateSondageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSondageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
