import { CmServiceService } from './../../shared/cm-service.service';
import { Component, OnInit } from '@angular/core';
import { LoanApprovedList } from 'app/model/loan-approved-list';
import { Location } from '@angular/common';

@Component({
  selector: 'app-creditmanager',
  templateUrl: './creditmanager.component.html',
  styleUrls: ['./creditmanager.component.css']
})
export class CreditmanagerComponent implements OnInit {

 
  constructor(public common : CmServiceService, public location : Location) { }
  customerList : LoanApprovedList[];
  ngOnInit(): void {
    this.common.getApplicantData().subscribe((data:LoanApprovedList[])=>{
      this.customerList = data;
    })
  }

  getSingleCustomer(id:number)
  {
    this.common.getSingleApplicantData(id).subscribe();
  } 

}
