import { Customer } from './../../../../../../OeModule/src/app/model/customer';
import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

import { CommonreService } from 'app/module/shared/commonre.service';

@Component({
  selector: 'app-enquiry',
  templateUrl: './enquiry.component.html',
  styleUrls: ['./enquiry.component.css']
})
export class EnquiryComponent implements OnInit {
  en:Customer[];
  constructor(public cs:CommonreService,public fb:FormBuilder,private loc:Location) { }
  registrationForm:FormGroup
  ngOnInit(): void {
    this.registrationForm=this.fb.group({
      customerId:[],
      fullName:[''],
      dob:[''],
      gender:[''],
      age:[],
      mobileNo:[''],
      email:[''],
      pancardNo:[''],
      aadharNo:['']
    })
  }
  onsubmit(){
    alert("Data Sending")
    this.cs.postdata(this.registrationForm.value).subscribe();
  }

  goBack(){
    this.loc.back();
  }

}
