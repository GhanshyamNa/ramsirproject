import { CmServiceService } from './../../shared/cm-service.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-emailsending',
  templateUrl: './emailsending.component.html',
  styleUrls: ['./emailsending.component.css']
})
export class EmailsendingComponent implements OnInit {

 sendEmail:FormGroup;
  constructor(public fb:FormBuilder,public commonservice:CmServiceService) { }

  ngOnInit(): void {
    this.sendEmail=this.fb.group({
      toEmail:[''],
     fromEmail:[''],
     subject:[''],
     textMessage:['']
    })
  }
  sendEmailCall()
  {
     this.commonservice.sendEmails(this.sendEmail.value).subscribe();
  }


}
