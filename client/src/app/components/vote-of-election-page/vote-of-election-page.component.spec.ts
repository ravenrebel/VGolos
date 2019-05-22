import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VoteOfElectionPageComponent } from './vote-of-election-page.component';

describe('VoteOfElectionPageComponent', () => {
  let component: VoteOfElectionPageComponent;
  let fixture: ComponentFixture<VoteOfElectionPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VoteOfElectionPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VoteOfElectionPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
