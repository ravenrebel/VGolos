import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCadidateComponent } from './create-cadidate.component';

describe('CreateCadidateComponent', () => {
  let component: CreateCadidateComponent;
  let fixture: ComponentFixture<CreateCadidateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateCadidateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateCadidateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
