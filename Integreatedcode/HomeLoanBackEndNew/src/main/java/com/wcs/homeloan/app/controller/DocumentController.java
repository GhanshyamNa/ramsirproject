package com.wcs.homeloan.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.homeloan.app.model.Applicant;
import com.wcs.homeloan.app.model.Document;
import com.wcs.homeloan.app.service.DocumentService;
@CrossOrigin("*")
@RestController
public class DocumentController {
	
	@Autowired
	DocumentService documentService;
	

	@GetMapping(value="/getAllApplicant")
	public ResponseEntity<List<Applicant>> getAllApplicantData()
	{
		return new ResponseEntity<>(documentService.findAll(),HttpStatus.OK);
	}
	
	@PutMapping(value="/updateVerificationStatus/{docId}")
	public ResponseEntity<Document> updatedata(@PathVariable int docId,@RequestBody Document app )
	{
		//System.out.println(app.getVerificationResult());
		 return new ResponseEntity<>(documentService.updateverifivation(docId,app),HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getSingleDocuments/{docId}")
	public ResponseEntity<Document> getDocuments(@PathVariable  int docId)
	{	
		return new ResponseEntity<>(documentService.findSingleDocument(docId),HttpStatus.OK);	
	}
	
	//***********DUMMY*******
	@GetMapping(value="/getsingleappdata/{applicationId}")
	public Applicant getsingledata(@PathVariable String applicationId )
	{
		return documentService.getsingelappdata(applicationId);
	}
	
	

}
