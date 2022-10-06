import { CustomerServiceService } from './../../shared/customer-service.service';

import { Component, OnInit } from '@angular/core';
import { Customer } from 'app/model/customer';
import { Cibil } from 'app/model/cibil';
import { Location } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private customeservice:CustomerServiceService,private location:Location) { }
  customer:Customer[];
  cibil:Cibil[];
    ngOnInit(): void {
      this.customeservice.getallcustomerdata().subscribe(data=>{this.customer=data})
  
    }
    getback()
    {
  this.location.back();
    }

}
