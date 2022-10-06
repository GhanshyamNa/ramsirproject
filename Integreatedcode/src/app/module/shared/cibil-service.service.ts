import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cibil } from 'app/model/cibil';
import { EmailSender } from 'app/model/email-sender';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CibilServiceService {

   url:string="http://localhost:8081/postCibilData";
  
  getcibilalldataurl:string="http://localhost:8081/getAllCibilData";

  sendemailurl:string="http://localhost:8081/sendCibilScoreEmail";
  
  
  constructor(private http:HttpClient) { }
  cibil:Cibil={

    cibilId:0,
	 cibilScore:0,
	cibilStatus:'',
	cibilRemark:'',
	
	 customer:{
    customerId:0,
		fullName:'',
		gender:'',
		dob:'',
    age:0,
    mobileNo:'',
		 email:'',
		 pancardNo:'',
	     aadharNo:''
}
    
}
postdata(id:number,cibil:Cibil)
{
  
  return this.http.post<Cibil>(this.url+"/"+id,cibil) // return this.http.put<Employee>(this.url+"/"+emp.id,emp);
}
getcibilalldata():Observable<Cibil[]>
{
  return this.http.get<Cibil[]>(this.getcibilalldataurl)
}
sendemail(e:EmailSender)
{
  alert("cibil serivce")
  return this.http.post<EmailSender>(this.sendemailurl,e)
}

}
