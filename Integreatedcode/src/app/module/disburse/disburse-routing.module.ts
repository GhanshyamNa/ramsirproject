import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoanDisburseComponent } from './loan-disburse/loan-disburse.component';
import { LoanapprovedlistComponent } from './loanapprovedlist/loanapprovedlist.component';

const routes: Routes = [
  {path:'loanlist', component:LoanapprovedlistComponent,
    children:[
      {path:'bank', component:LoanDisburseComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DisburseRoutingModule { }
