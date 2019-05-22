import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOfElectionsCompletedComponent } from './list-of-elections-completed.component';

describe('ListOfElectionsCompletedComponent', () => {
  let component: ListOfElectionsCompletedComponent;
  let fixture: ComponentFixture<ListOfElectionsCompletedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListOfElectionsCompletedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListOfElectionsCompletedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
