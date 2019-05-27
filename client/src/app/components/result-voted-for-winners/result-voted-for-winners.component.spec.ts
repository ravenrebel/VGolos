import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultVotedForWinnersComponent } from './result-voted-for-winners.component';

describe('ResultVotedForWinnersComponent', () => {
  let component: ResultVotedForWinnersComponent;
  let fixture: ComponentFixture<ResultVotedForWinnersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResultVotedForWinnersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResultVotedForWinnersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
