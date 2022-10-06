import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LedgerForm } from 'app/model/ledger-form';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommonserviceService {
  url:string="http://localhost:8081/ledger/add";
  getURL:string="http://localhost:8081/ledger/get";
  constructor(private http: HttpClient) { }

  l:LedgerForm={
    ledgerId: 0,
    customerName: '',
    ledgerCreationDate: '',
    totalLoanAmount: 0,
    payableAmountWithIntrest: 0,
    tenureInYear: 0,
    monthlyEMI: 0,
    amountPaidTillDate: 0,
    remainingAmount: 0,
    defaulterCount: 0,
    previousEmiStatus: '',
    currentMonthEmiStatus: '',
    loanEndDate: '',
    loanStatus: ''
  }

  getdata(): Observable<LedgerForm[]>
  {
    return this.http.get<LedgerForm[]>(this.getURL);
  }
  postdata(form:LedgerForm):Observable<LedgerForm>
  {
    console.log("postdata service");
    console.log(form.ledgerId);
    
    
     return this.http.post<LedgerForm>(this.url,form);
  }
}
