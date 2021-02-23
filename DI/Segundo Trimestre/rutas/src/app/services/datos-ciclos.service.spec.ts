import { TestBed } from '@angular/core/testing';

import { DatosCiclosService } from './datos-ciclos.service';

describe('DatosCiclosService', () => {
  let service: DatosCiclosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DatosCiclosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
