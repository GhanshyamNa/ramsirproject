import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanapprovedlistComponent } from './loanapprovedlist.component';

describe('LoanapprovedlistComponent', () => {
  let component: LoanapprovedlistComponent;
  let fixture: ComponentFixture<LoanapprovedlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoanapprovedlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoanapprovedlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
