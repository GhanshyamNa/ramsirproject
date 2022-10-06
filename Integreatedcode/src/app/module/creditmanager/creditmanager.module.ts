import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreditmanagerComponent } from './creditmanager/creditmanager.component';
import { RouterModule, Routes } from '@angular/router';
import { EmailsendingComponent } from './emailsending/emailsending.component';
import { EmiCalculatorComponent } from './emi-calculator/emi-calculator.component';
import { SactionListComponent } from './saction-list/saction-list.component';
import { SanctionLetterGeneratorComponent } from './sanction-letter-generator/sanction-letter-generator.component';

const routing: Routes = [
  { path: "credit", component: CreditmanagerComponent,
    children: [
      { path: "calshi", component: EmiCalculatorComponent },
    ] },
  
  {
    path: "Letter", component: SactionListComponent,
    children: [
      {path: "sanctionletter/:id", component: SanctionLetterGeneratorComponent}
    ]  },
   {path: "mail", component: EmailsendingComponent}
  
];

@NgModule({
  declarations: [CreditmanagerComponent, EmailsendingComponent, EmiCalculatorComponent, SactionListComponent, SanctionLetterGeneratorComponent],
  imports: [
    CommonModule,RouterModule.forChild(routing)
  ]
})
export class CreditmanagerModule { }
