import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultCitizenPageComponent } from './result-citizen-page.component';

describe('ResultCitizenPageComponent', () => {
  let component: ResultCitizenPageComponent;
  let fixture: ComponentFixture<ResultCitizenPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResultCitizenPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResultCitizenPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
