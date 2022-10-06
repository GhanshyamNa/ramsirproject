import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CommonreService } from 'app/module/shared/commonre.service';

@Component({
  selector: 'app-email-sending',
  templateUrl: './email-sending.component.html',
  styleUrls: ['./email-sending.component.css']
})
export class EmailSendingComponent implements OnInit {

  constructor(public cs:CommonreService,private fb:FormBuilder,private loc:Location) { }
  registrationForm:FormGroup

  ngOnInit(): void {
    this.registrationForm=this.fb.group({
     
      toEmail:[''],
      subject:[''],
      textMassage:['']
    })
  }
  onsubmit(){
    this.cs.postEmail(this.registrationForm.value).subscribe();
      }
      goBack(){
        
      }

}
