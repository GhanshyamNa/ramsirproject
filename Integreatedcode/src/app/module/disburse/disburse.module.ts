import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DisburseRoutingModule } from './disburse-routing.module';
import { RouterModule, Routes } from '@angular/router';
import { LoanapprovedlistComponent } from './loanapprovedlist/loanapprovedlist.component';
import { LoanDisburseComponent } from './loan-disburse/loan-disburse.component';
import { LedgerformComponent } from './ledgerform/ledgerform.component';
import { LedgerformViewComponent } from './ledgerform-view/ledgerform-view.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


const acrouting: Routes = [
  {path:'loanlist', component:LoanapprovedlistComponent},
  // {path: 'bank', component:LoanDisburseComponent},
  {path:'ledgerform', component: LedgerformComponent},
  {path:'ledgerview', component:LedgerformViewComponent}
];

@NgModule({
  declarations: [LoanapprovedlistComponent, LedgerformComponent, LedgerformViewComponent, LoanDisburseComponent],
  imports: [
    CommonModule,
    DisburseRoutingModule,FormsModule,ReactiveFormsModule,RouterModule.forChild(acrouting)
  ]
})
export class DisburseModule { }
