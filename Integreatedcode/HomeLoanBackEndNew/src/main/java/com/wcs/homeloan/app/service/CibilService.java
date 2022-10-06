package com.wcs.homeloan.app.service;

import com.wcs.homeloan.app.model.Cibil;
import com.wcs.homeloan.app.model.Customer;

import java.util.List;


public interface CibilService {

	public Cibil postCibilData(int cust_Id, Cibil ad);

	public List<Customer> getAllCustomerData();

	public List<Cibil> getallcibildata();

  public	Customer getSingleCustomerdata(int customerId);



//*********dummy
Customer saveDummydata(Customer ad);
	 Cibil getspprovedlist(Integer cibilStatus);
	
	Cibil getSingleCibildata(int cibilId);

	public Customer updatecibilstatus(int customerId, Customer c);
 







	

}
