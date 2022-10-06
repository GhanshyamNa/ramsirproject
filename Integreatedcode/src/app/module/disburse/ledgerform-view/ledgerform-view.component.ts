import { Component, OnInit } from '@angular/core';
import { LedgerForm } from 'app/model/ledger-form';
import { CommonserviceService } from 'app/module/shared/commonservice.service';
import { ngxCsv } from 'ngx-csv';

@Component({
  selector: 'app-ledgerform-view',
  templateUrl: './ledgerform-view.component.html',
  styleUrls: ['./ledgerform-view.component.css']
})
export class LedgerformViewComponent implements OnInit {
  ledgerlist: LedgerForm[];
 
  constructor(private serve: CommonserviceService) { }

  ngOnInit(): void {
    this.serve.getdata().subscribe(data => this.ledgerlist = data);
  }
filedownload() {
   var options = { 
    fieldSeparator: ',',
    quoteStrings: '"',
    decimalseparator: '.',
    showLabels: true, 
    showTitle: true,
    title: 'Ledger Report Data',
    useBom: true,
    noDownload: false,
    headers: ["ledgerId", "customerName", "ledgerCreationDate","totalLoanAmount","payableAmountWithIntrest","tenureInYear","monthlyEMI","amountPaidTillDate","remainingAmount","defaulterCount","previousEmiStatus","currentMonthEmiStatus","loanEndDate","loanStatus"]
  };
 
  new ngxCsv(this.ledgerlist, "Ledger Report", options);
  }
}
