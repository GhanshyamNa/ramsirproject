package com.wcs.homeloan.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.homeloan.app.model.Applicant;
import com.wcs.homeloan.app.model.Customer;
import com.wcs.homeloan.app.service.ApplicationService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ApplicantController {

	@Autowired
	ApplicationService hlsi;
	
	@PostMapping("/postdata")
	public ResponseEntity<Customer>postdata(@RequestBody Customer a ){
		System.out.println("geneder"+a.getGender());
		return new ResponseEntity<Customer>(hlsi.saveApplicantData(a),HttpStatus.CREATED);
	}
	@GetMapping("/getdata")
	public ResponseEntity<Iterable<Customer>> geteApplicantData(){
		
		return new ResponseEntity<Iterable<Customer>>(hlsi.geteApplicantData(),HttpStatus.OK);
	}
	@PostMapping("/postdataApplicant/{customerId}")
	public ResponseEntity<Applicant>postdataApp(@PathVariable Integer customerId,@RequestBody Applicant a ){
	;
		return new ResponseEntity<Applicant>(hlsi.saveApplicantDataApp(customerId,a),HttpStatus.CREATED);
	}
	
	
	
	
}
