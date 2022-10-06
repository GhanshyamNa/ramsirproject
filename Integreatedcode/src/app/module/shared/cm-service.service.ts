import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EmailSender } from 'app/model/email-sender';
import { LoanApprovedList } from 'app/model/loan-approved-list';
import { SanctionLetter } from 'app/model/sanction-letter';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CmServiceService {

  sendEmails(email:EmailSender) {
    return this.http.post("http://localhost:9090/emailsendwithattachment",email);
  }

  constructor(private http : HttpClient) { }

  getApplicantData()
  {
    return this.http.get("http://localhost:9090/getLoanApprovedList");
  }

  getSingleApplicantData(id : number):Observable<LoanApprovedList>
  {
    return this.http.get<LoanApprovedList>("http://localhost:9090/getLoanApprovedCustomerList/"+id);
  }

  calculateEMI(id:number,emi:LoanApprovedList)
  {
    return this.http.post("http://localhost:9090/calculateEMI/"+id,emi);
  }

  getAllSanctionLetterData()
  {
    return this.http.get("http://localhost:9090/getAllSanctionLetterData");
  }

  getDataForLetter(id:number):Observable<SanctionLetter>
  {
    return this.http.get<SanctionLetter>("http://localhost:9090/getSanctionLetterData/"+id);
  }
}
