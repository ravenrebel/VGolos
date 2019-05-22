import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomePageListOfElectionsComponent } from './home-page-list-of-elections.component';

describe('HomePageListOfElectionsComponent', () => {
  let component: HomePageListOfElectionsComponent;
  let fixture: ComponentFixture<HomePageListOfElectionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomePageListOfElectionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomePageListOfElectionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
