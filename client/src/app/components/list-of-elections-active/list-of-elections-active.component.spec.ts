import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOfElectionsActiveComponent } from './list-of-elections-active.component';

describe('ListOfElectionsActiveComponent', () => {
  let component: ListOfElectionsActiveComponent;
  let fixture: ComponentFixture<ListOfElectionsActiveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListOfElectionsActiveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListOfElectionsActiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
