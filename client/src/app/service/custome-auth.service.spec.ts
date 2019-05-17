import { TestBed } from '@angular/core/testing';

import { CustomeAuthService } from './custome-auth.service';

describe('CustomeAuthService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomeAuthService = TestBed.get(CustomeAuthService);
    expect(service).toBeTruthy();
  });
});
