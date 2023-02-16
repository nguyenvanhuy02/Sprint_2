import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MuonComponent } from './muon.component';

describe('MuonComponent', () => {
  let component: MuonComponent;
  let fixture: ComponentFixture<MuonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MuonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MuonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
