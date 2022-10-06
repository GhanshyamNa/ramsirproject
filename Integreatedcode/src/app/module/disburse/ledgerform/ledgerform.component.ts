import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { LedgerForm } from 'app/model/ledger-form';
import { CommonserviceService } from 'app/module/shared/commonservice.service';


@Component({
  selector: 'app-ledgerform',
  templateUrl: './ledgerform.component.html',
  styleUrls: ['./ledgerform.component.css']
})
export class LedgerformComponent implements OnInit {
  ledgerForm:FormGroup;
  constructor(private s:CommonserviceService, private formbuilder:FormBuilder) { }
   l:LedgerForm[]
  ngOnInit(): void {
   this.ledgerForm=this.formbuilder.group(
      {
      ledgerId:[],
      customerName:[''],
      ledgerCreationDate:[''],
      totalLoanAmount:[],
      payableAmountWithIntrest:[],
      tenureInYear:[],
      monthlyEMI:[],
      amountPaidTillDate:[],
      remainingAmount:[],
      defaulterCount:[],
      previousEmiStatus:[''],
      currentMonthEmiStatus:[''],
      loanEndDate:[''],
      loanStatus:['']




    })
  }
    onSubmit()
  {
    if(this.ledgerForm.valid){
      alert("Register Successfully");
      console.log("ledgerform ts");

      this.s.postdata(this.ledgerForm.value).subscribe();
      window.location.reload();
    }
  }
    // submitdata(ld:Ledgerform)
    // {
    //   alert("Data Submited");
    //   console.log(this.ledgerForm.controls['ledgerId'].value);
      
    //  this.s.postdata(ld).subscribe();
    // }
  
  

}
