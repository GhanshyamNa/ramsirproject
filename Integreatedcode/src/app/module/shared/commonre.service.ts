import { Applicant } from './../../model/applicant';
import { EmailSender } from './../../model/email-sender';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import { Cibil } from 'app/model/cibil';
import { Customer } from 'app/model/customer';



@Injectable({
  providedIn: 'root'
})
export class CommonreService {
  //url:string="http://localhost:3000/Enquiry";
  url:string="http://localhost:8081/api/postdata";
  urlg:string="http://localhost:8081/api/getdata";
  urlcibi:string="http://localhost:8081/api/getdatacibil";
  urldocumentpost:string="http://localhost:8081/api/uploadDocument";
  urldocumentget:string="http://localhost:8081/api/get";
  urlsendEmail:string="http://localhost:8081/api/sendEmailWithAttachement";
  urlpostApplicant:string="http://localhost:8081/api/postdataApplicant";
  urlgetaprovaldata:string="http://localhost:8081/api/getdataScationAprovale";
    constructor(public ht:HttpClient) { }
  
    postdata(en:Customer){
      return this.ht.post(this.url,en);
    }
    
    getedata(){
      return this.ht.get<Customer[]>(this.urlg);
    }
    geteCibil(){
      return this.ht.get<Cibil[]>(this.urlcibi);
    }
    postDocument(id:number,doc:any){
      return this.ht.post(this.urldocumentpost+"/"+id,doc);
    }
    getdataDocument(){
      return this.ht.get(this.urldocumentget);
    }
    postEmail(email:EmailSender){
      return this.ht.post(this.urlsendEmail,email)
    }
    postdatacust(id:number,cust:Applicant){
      return this.ht.post(this.urlpostApplicant+"/"+id,cust);
    }
    getedataSactionaproval(){
  
     return this.ht.get(this.urlgetaprovaldata);
    }
  }