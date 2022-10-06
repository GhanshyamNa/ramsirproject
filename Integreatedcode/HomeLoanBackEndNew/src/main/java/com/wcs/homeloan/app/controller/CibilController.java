package com.wcs.homeloan.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.wcs.homeloan.app.model.Customer;
import com.wcs.homeloan.app.model.Cibil;
import com.wcs.homeloan.app.service.CibilService;

@CrossOrigin("*")
@RestController
public class CibilController {
	@Autowired 
	CibilService cibilService;
		

	@PostMapping(value="/postCibilData/{customerId}")
	public ResponseEntity<Cibil> postCibilData(@PathVariable int customerId ,@RequestBody Cibil cibil)
	{
	   return new ResponseEntity<>(cibilService.postCibilData(customerId,cibil),HttpStatus.CREATED)   ;                                     
	}
	
	
	@GetMapping(value="/getSingleCustomer/{customerId}")
	public ResponseEntity<Customer> getSingleCustomerdata(@PathVariable int customerId )
	{
		return new ResponseEntity<>(cibilService.getSingleCustomerdata(customerId),HttpStatus.OK);
	}

	@GetMapping(value="/getAllCibilData")
	public ResponseEntity<List<Cibil>> getAllCibilData()
	{
		return new ResponseEntity<>(cibilService.getallcibildata(),HttpStatus.OK);
	}


	
	
	@GetMapping(value="/getAllCustomerData")
	public ResponseEntity<List<Customer>> getAllCustomerData()
	{
		return new ResponseEntity<>(cibilService.getAllCustomerData(),HttpStatus.OK)  ;           
	}
//*************DUMMY****************
	
	@PostMapping(value="/postcustomerdata")
	public ResponseEntity<Customer>  postdummyData(@RequestBody Customer ad)
	{
		return  new ResponseEntity<>(cibilService.saveDummydata(ad),HttpStatus.CREATED)   ;     
	}
	
	@GetMapping(value="getSingleCibil/{cibilId}")
	public Cibil getSingleCibildata(@PathVariable int cibilId)
	{
		return cibilService.getSingleCibildata(cibilId);
	}
	@PutMapping(value="/updatecustomerdata/{customerId}")
	public Customer cus(@PathVariable int customerId ,@RequestBody Customer c )
	{
		return cibilService.updatecibilstatus(customerId,c);
		
	}
	
	}
