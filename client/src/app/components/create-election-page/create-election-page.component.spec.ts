import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateElectionPageComponent } from './create-election-page.component';

describe('CreateElectionPageComponent', () => {
  let component: CreateElectionPageComponent;
  let fixture: ComponentFixture<CreateElectionPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateElectionPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateElectionPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
