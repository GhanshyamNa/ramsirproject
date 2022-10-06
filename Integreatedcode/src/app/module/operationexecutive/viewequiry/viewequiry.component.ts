import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Cibil } from 'app/model/cibil';
import { Customer } from 'app/model/customer';
import { CibilServiceService } from 'app/module/shared/cibil-service.service';

@Component({
  selector: 'app-viewequiry',
  templateUrl: './viewequiry.component.html',
  styleUrls: ['./viewequiry.component.css']
})
export class ViewequiryComponent implements OnInit {

   constructor(private cibilservice:CibilServiceService, private location :Location) { }
  cibil:Cibil[];
  cibil1:Cibil;
  ngOnInit(): void {
    this.cibilservice.getcibilalldata().subscribe(data=>{this.cibil=data})
   
  }
  getback()
    {
  this.location.back();
    }
  emailed(doc:Customer)
  {
    

  }

}
