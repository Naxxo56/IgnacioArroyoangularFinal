import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CicloDetalleComponent } from './ciclo-detalle.component';

describe('CicloDetalleComponent', () => {
  let component: CicloDetalleComponent;
  let fixture: ComponentFixture<CicloDetalleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CicloDetalleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CicloDetalleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
