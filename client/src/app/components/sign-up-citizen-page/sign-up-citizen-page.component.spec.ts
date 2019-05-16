import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SignUpCitizenPageComponent } from './sign-up-citizen-page.component';

describe('SignUpCitizenPageComponent', () => {
  let component: SignUpCitizenPageComponent;
  let fixture: ComponentFixture<SignUpCitizenPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SignUpCitizenPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignUpCitizenPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
