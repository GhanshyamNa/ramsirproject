package com.wcs.homeloan.app.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wcs.homeloan.app.model.Customer;
import com.wcs.homeloan.app.model.Cibil;

import com.wcs.homeloan.app.repository.CibilRepository;
import com.wcs.homeloan.app.repository.CustomerRepository;
import com.wcs.homeloan.app.service.CibilService;

@Service
public class CibilServiceImpl implements CibilService{

	@Autowired
	CibilRepository cibilRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	
	
	


	@Override
	public Cibil postCibilData(int customerId, Cibil cibil) {
		
		Optional<Customer> customer = customerRepository.findById(customerId);
		
       cibil.setCustomer(customer.get());
	   
	 
      //   System.out.println("cibil score "+cibil.getCibilScore());
      cibilRepository.save(cibil);
		return cibil;
	}
	
	
	
	@Override
	public Customer getSingleCustomerdata(int customerId) {
		
		return customerRepository.findByCustomerId(customerId);
	}

	@Override
	public List<Cibil> getallcibildata() {
		
		return cibilRepository.findAll();
	}
	@Override
	public List<Customer> getAllCustomerData() {
		
		return customerRepository.findAll();
	}

//***********DUMMY**************
	

	@Override
	public Customer saveDummydata(Customer ad) {
		
		return customerRepository.save(ad);
	}







	






	@Override
	public Cibil getspprovedlist(Integer cibilId) {
		
		return cibilRepository.findByCibilId(cibilId);
	}







	







	@Override
	public Cibil getSingleCibildata(int cibilId) {
		
		return cibilRepository.findByCibilId(cibilId);
	}



	@Override
	public Customer updatecibilstatus(int customerId, Customer c) {
		c.setCustomerId(customerId);
		return customerRepository.save(c);
	}







	

	


	

}
