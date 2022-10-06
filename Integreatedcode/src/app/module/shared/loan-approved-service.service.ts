import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoanApprovedList } from 'app/model/loan-approved-list';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoanApprovedServiceService {

  getURL:string="http://localhost:8081/sanction/get";
  getloanurl: string = "http://localhost:8081/sanction/getloan";
  constructor(private http:HttpClient) { }
  
  l:LoanApprovedList ={
    loanAid: 0,
    loanDetails: {
      loanDetailId:0,
	    totalLoanRequired:0,
      tenureofLoan: 0,
      annualInterest:0
    },
     sanction: {
          sanctionedId: 0,
    sanctionedLoanAmount:0,
    loanRefundTenure: 0,
    reteOfInterest: 6.7,
     },
     applicant: {
      applicationId: '',
   education: '',
       nationality: '',
       profession: '',
   
    customer: {
      customerId: 0,    
    fullName: '',
    gender: '',
    dob: '',
    age: 0,
    mobileNo:'',
    email: '',
    pancardNo: '',
    aadharNo: '',
    },
       caddr: {
      caId: 0,
    streetName: '',
    areaName: '',
    cityName: '',
    districtName: '',
    stateName: '',
    pincodeNo: 0,
    },
    paddr: {
       paId: 0,
    streetName: '',
    areaName: '',
    cityName: '',
    districtName: '',
    stateName: '',
    pincodeNo: 0,
    },
    loanDetails:  {
     loanDetailId:0,
	     totalLoanRequired:0,
      tenureofLoan: 0,
      annualInterest:0
    },
       propertydetails: {
       propertyId: 0,
    propertyType: '',
    propertyPrice: '',
    propertyLocation: '',
    },
       bankdetails: {
     bankId: 0,
    caccountNo: 0,
    ifscCode: '',
    bankName: '',
    micrcode: '',
    branchAddress: '',
       },
       verificationResult:"Pending",
    
  
    }
  }
  getdata():Observable<LoanApprovedList[]>
{
   
  
  return this.http.get<LoanApprovedList[]>(this.getURL);
}
// postdata(lal:LoanApprovedList)
// {
//   return this.http.post(this.getURL,lal);
// }
getloanbyid(loan:LoanApprovedList): Observable<LoanApprovedList>
{
  return this.http.get<LoanApprovedList>(this.getloanurl+'/'+loan.loanAid);
}
}
