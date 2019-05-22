import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultVotersInTheirCityPageComponent } from './result-voters-in-their-city-page.component';

describe('ResultVotersInTheirCityPageComponent', () => {
  let component: ResultVotersInTheirCityPageComponent;
  let fixture: ComponentFixture<ResultVotersInTheirCityPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResultVotersInTheirCityPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResultVotersInTheirCityPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
