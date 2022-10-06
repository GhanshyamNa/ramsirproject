import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanDisburseComponent } from './loan-disburse.component';

describe('LoanDisburseComponent', () => {
  let component: LoanDisburseComponent;
  let fixture: ComponentFixture<LoanDisburseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoanDisburseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoanDisburseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
