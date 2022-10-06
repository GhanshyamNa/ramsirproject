import { LoanApprovedServiceService } from './../../shared/loan-approved-service.service';
import { Component, OnInit } from '@angular/core';
import { LoanApprovedList } from 'app/model/loan-approved-list';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-loanapprovedlist',
  templateUrl: './loanapprovedlist.component.html',
  styleUrls: ['./loanapprovedlist.component.css']
})
export class LoanapprovedlistComponent implements OnInit {

  constructor(private las: LoanApprovedServiceService, private routes:ActivatedRoute) { }
   l:LoanApprovedList[]; 
   
  ngOnInit(): void {
    this.las.getdata().subscribe(data => this.l = data)
     
  }
  


 
}
