import { TestBed } from '@angular/core/testing';

import { CandidateControllerService } from './candidate-controller.service';

describe('CandidateControllerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CandidateControllerService = TestBed.get(CandidateControllerService);
    expect(service).toBeTruthy();
  });
});
