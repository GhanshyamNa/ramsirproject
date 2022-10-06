import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from 'app/model/customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

   getAllDataUrl:string="http://localhost:8081/getAllCustomerData";
getSingleDataUrl:string="http://localhost:8081/getSingleCustomer";
  constructor(private http:HttpClient) { }
  
  customer:Customer={
    customerId:0,
		fullName:'',
		gender:'',
		dob:'',
    age:0,
    mobileNo:'',
		 email:'',
		 pancardNo:'',
	     aadharNo:'',
       
}
getallcustomerdata():Observable<Customer[]>
{
  return this.http.get<Customer[]>(this.getAllDataUrl);
}
getcustomersinlgedata(id:number):Observable<Customer>
 {
  return this.http.get<Customer>(this.getSingleDataUrl+"/"+id);
 }
}
