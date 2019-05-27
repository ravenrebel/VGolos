import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultListVotersComponent } from './result-list-voters.component';

describe('ResultListVotersComponent', () => {
  let component: ResultListVotersComponent;
  let fixture: ComponentFixture<ResultListVotersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResultListVotersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResultListVotersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
