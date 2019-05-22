import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultStatisticsAverageAgePageComponent } from './result-statistics-average-age-page.component';

describe('ResultStatisticsAverageAgePageComponent', () => {
  let component: ResultStatisticsAverageAgePageComponent;
  let fixture: ComponentFixture<ResultStatisticsAverageAgePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResultStatisticsAverageAgePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResultStatisticsAverageAgePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
