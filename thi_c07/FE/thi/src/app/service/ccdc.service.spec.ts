import { TestBed } from '@angular/core/testing';

import { CcdcService } from './ccdc.service';

describe('CcdcService', () => {
  let service: CcdcService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CcdcService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
