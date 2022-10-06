import { CmServiceService } from './../../shared/cm-service.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { LoanApprovedList } from 'app/model/loan-approved-list';
import { Location } from '@angular/common';

@Component({
  selector: 'app-emi-calculator',
  templateUrl: './emi-calculator.component.html',
  styleUrls: ['./emi-calculator.component.css']
})
export class EmiCalculatorComponent implements OnInit {

  constructor(public fb : FormBuilder,public location :Location, public common : CmServiceService, private routes : ActivatedRoute) { }
  
  loanapprovedObj : LoanApprovedList;
  lAid : number;

  emicalculator : FormGroup;
  
  ngOnInit(): void {
    this.emicalculator = this.fb.group({
      loanAid : [''],
      loandetails : this.fb.group({
        totalLoanRequired : [''],
        tenureofLoan : ['']
      }),
      sanction : this.fb.group({
        rateofInterest : [''],
        sanctionedAmount : ['']
      })
    })
    this.fetchData();
  }

  goBack()
  {
    this.location.back();
  }

  fetchData()
  {
    let obj : any = this.location.getState();
    console.log(obj.loanAid);
    this.lAid = obj.loanAid;

    if(obj!=0)  
    {
      this.emicalculator.controls['sanction'].get('rateofInterest').setValue(obj.sanction.rateofInterest);
      this.emicalculator.controls['sanction'].get('sanctionedAmount').setValue(obj.sanction.sanctionedAmount);
      this.emicalculator.controls['loandetails'].get('totalLoanRequired').setValue(obj.loandetails.totalLoanRequired);
      this.emicalculator.controls['loandetails'].get('tenureofLoan').setValue(obj.loandetails.tenureofLoan);
    }
  }

  calculate()
  {
    this.common.calculateEMI(this.lAid,this.emicalculator.value).subscribe();
  }

}
