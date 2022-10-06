
import { LoanApprovedServiceService } from './../../shared/loan-approved-service.service';
import { LoanApprovedList } from 'app/model/loan-approved-list';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Location } from '@angular/common';

@Component({
  selector: 'app-loan-disburse',
  templateUrl: './loan-disburse.component.html',
  styleUrls: ['./loan-disburse.component.css']
})
export class LoanDisburseComponent implements OnInit {
  l: LoanApprovedList[];

  constructor(private b:LoanApprovedServiceService , private formBuilder:FormBuilder, private location:Location) { }
  bankForm:FormGroup;
   
  ngOnInit(): void {
    this.b.getdata().subscribe(data => this.l = data);
    
    this.bankForm=this.formBuilder.group(
      {
     loanAid: [],
    monthlyEMIAmount: [],
    principalAmount: [],
    totalInterest: [],
    totalAmount: [],
    loanDetails: {
      loanDetailId:[],
	     totalLoanRequired:[],
	    tenureofLoan:[],
    },
     sanction: {
          sanctionedId: [],
    sanctionedLoanAmount:[],
    loanRefundTenure: [],
    reteOfInterest: [],
     },
     applicant: {
      applicationId: [''],
   education: [''],
   nationality: [''],
    customer: {
      customerId: [],    
    fullName: [''],
    gender: [''],
    dob: [''],
    age: [],
    mobileNo:[''],
    email: [''],
    pancardNo: [''],
    aadharNo: [''],
    },
       caddr: {
      caId: [],
    streetName: [''],
    areaName: [''],
    cityName: [''],
    districtName: [''],
    stateName: [''],
    pincodeNo: [],
    },
    paddr: {
        caId: [],
    streetName: [''],
    areaName: [''],
    cityName: [''],
    districtName: [''],
    stateName: [''],
    pincodeNo: [],
    },
    loandetails:  {
     loanDetailId:[],
	     totalLoanRequired:[],
	    tenureofLoan:[],
    },
       propertydetails: {
       propertyId: [],
    propertyType: [''],
    propertyPrice: [''],
    propertyLocation: [''],
    },
    documentup: {
       docId: [],
    photo: [],
    signature: [],
    panCard: [],
    addressProof: [],
    incomeDocument: [],
    aadharCard: [],
    propertyDocument: [],
    bankcheque: [],     
    },
    bankdetails: {
       bankId: [],
    caccountNo: [],
    ifscCode: [''],
    bankName: [''],
    micrcode: [''],
    branchAddress: [''],
    },
    profession: [''],
       cibil: {
       cibilId: [],
    cibilScore: [],
    cibilStatus: [''],
         cibilRemark: [''],
         customer: {
      
         customerId: [],
        fullName: [''],
            gender: [''],
            dob: [''],
          age: [],
            mobileNo: [''],
              email: [''],
                pancardNo: [''],
                  aadharNo: [''],
      
    }
    }
    }

    })
  
    this.editData();
  }
  editData()
  {
    let loan:any = this.location.getState();
    console.log(loan.applicant.bankdetails.cAccountNo);
    console.log(loan.applicant.bankdetails.bankId);
    if(loan.loanAid!=0){
      this.bankForm.get('loanAid').setValue(loan.loanAid);
      this.bankForm.get('cAccountNo').setValue(loan.applicant.bankdetails.cAccountNo);
    }
    

  }
  onSubmit()
  {
    if(this.bankForm.valid){
      alert("Disburse Successfully");
      console.log("ledgerform ts");

     
      window.location.reload();
    }
  }

}
