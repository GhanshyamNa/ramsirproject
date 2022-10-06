package com.wcs.homeloan.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.homeloan.app.model.LoanApprovedList;
import com.wcs.homeloan.app.service.ServiceI;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/sanction")
public class LoanController {

	@Autowired
	ServiceI si;

//	@PostMapping(value = "/post")
//	public ResponseEntity<LoanApprovedList> postData(@RequestBody LoanApprovedList loanApprovesList)
//	{
//		return new ResponseEntity<LoanApprovedList>(si.saveData(loanApprovesList),HttpStatus.CREATED);
//	}

	@GetMapping(value = "/get")
	public ResponseEntity<Iterable<LoanApprovedList>> getAllData() {
		return new ResponseEntity<Iterable<LoanApprovedList>>(si.getData(), HttpStatus.OK);

	}

	@GetMapping(value = "/getloan/{id}")
	public ResponseEntity<Optional<LoanApprovedList>> bank(@PathVariable int id) {
		
		return new ResponseEntity<Optional<LoanApprovedList>>(si.getloanbyid(id), HttpStatus.OK);
	}

}
