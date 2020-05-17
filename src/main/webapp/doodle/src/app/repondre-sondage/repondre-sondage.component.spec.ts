import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RepondreSondageComponent } from './repondre-sondage.component';

describe('RepondreSondageComponent', () => {
  let component: RepondreSondageComponent;
  let fixture: ComponentFixture<RepondreSondageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RepondreSondageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RepondreSondageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
