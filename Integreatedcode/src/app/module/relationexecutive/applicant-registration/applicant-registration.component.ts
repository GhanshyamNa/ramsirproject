import { Applicant } from './../../../model/applicant';
import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

import { CommonreService } from 'app/module/shared/commonre.service';

@Component({
  selector: 'app-applicant-registration',
  templateUrl: './applicant-registration.component.html',
  styleUrls: ['./applicant-registration.component.css']
})
export class ApplicantRegistrationComponent implements OnInit {
  custreg:Applicant[];
  constructor(public cs:CommonreService,public fb:FormBuilder,private loc:Location) { }
  registrationForm:FormGroup;
  custId:number;
  streetName:string;
  ngOnInit(): void {
this.registrationForm=this.fb.group({
  applicationId:[''],
  education:[''],
  nationality:[''],
  profession:[''],
  customer:this.fb.group({
  customerId:[],
  fullName:[''],
  gender:[''],
  dob:[''],
  age:[''],
  mobileNo:[''],
  email:[''],
  pancardNo:[''],
  aadharNo:[''],
  }),
  caddr:this.fb.group({
    caId:[],
    streetName:[''],
    areaName:[''],
    cityName:[''],
    districtName:[''],
    stateName:[''],
    pincodeNo:[''],
  }),
  paddr:this.fb.group({
    paId:[],
    streetName:[''],
    areaName:[''],
    cityName:[''],
    districtName:[''],
    stateName:[''],
    pincodeNo:[''],
  }),
  loanDetails:this.fb.group({

    loandetailId:[],
    totalLoanRequired:[],
    tenureofLoan:[],
    annualInterest:[],
  }),
  propertyDetails:this.fb.group({

    propertyId:[],
    propertyType:[''],
    propertyPrice:[''],
    propertyLocation:[''],
  }),
  bankDetails:this.fb.group({

    bankId:[],
    caccountNo:[],
    ifscCode:[''],
    bankName:[''],
    bankcode:[''],
    micrcode:[''],
    branchAddress:[''],
  }),
    verificationResult:['Pending']
  // doId:this.fb.group({

  //   docId:[],
  //   photo:[''],
  //   signature:[''],
  //   panCard:[''],
  //   addressProof:[''],
  //   incomeDocument:[''],
  //   aadharCard:[''],
  //   propertyDocument:[''],
  //   blankchecque:[''],
   
  // }),

     
 })
this.edit()
  }
 
  autoFilAddress(){
    this.streetName=""
    
  }
  onsubmit(){
alert("Succuss Fully Add")
    this.cs.postdatacust(this.custId,this.registrationForm.value).subscribe()
  }
  edit(){
    let s:any=this.loc.getState();
    console.log(s.customerId);
    this.custId=s.customerId;
    console.log("in method");
    if(s.customerId!=0){
      ;
     
     console.log("get data ");
    // this.registrationForm.controls.customer.get('customerId')?.setValue(s.customerId);
     this.registrationForm.controls.customer.get('fullName')?.setValue(s.fullName);
     this.registrationForm.controls.customer.get('gender')?.setValue(s.gender);
     this.registrationForm.controls.customer.get('dob')?.setValue(s.dob);
     this.registrationForm.controls.customer.get('age')?.setValue(s.age);
     this.registrationForm.controls.customer.get('email')?.setValue(s.email);
     this.registrationForm.controls.customer.get('mobileNo')?.setValue(s.mobileNo);
     this.registrationForm.controls.customer.get('pancardNo')?.setValue(s.pancardNo);
     this.registrationForm.controls.customer.get('aadharNo')?.setValue(s.aadharNo);
 
   
   
    }
     }
   
    
  
  goBack(){
    this.loc.back();
  }


}
