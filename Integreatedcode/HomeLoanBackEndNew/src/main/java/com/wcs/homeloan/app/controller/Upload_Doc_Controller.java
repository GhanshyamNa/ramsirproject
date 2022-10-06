package com.wcs.homeloan.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wcs.homeloan.app.model.Document;
import com.wcs.homeloan.app.service.ApplicationService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class Upload_Doc_Controller {
	
	
	@Autowired
	ApplicationService hlsi;
	
	@PostMapping(value = "/uploadDocument/{doc}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public List<Document> uploadDocument(@RequestPart(required =true,value ="photo")MultipartFile file1,
			@RequestPart(required = true,value ="signature")MultipartFile file2,
			@RequestPart(required = true,value ="panCard")MultipartFile file3,
			@RequestPart(required = true,value ="addressProof")MultipartFile file4,
			@RequestPart(required = true,value ="incomeDocument")MultipartFile file5,
			@RequestPart(required = true,value ="aadharCard")MultipartFile file6,
			@RequestPart(required = true,value ="propertyDocument")MultipartFile file7,
			@RequestPart(required = true,value ="blankchecque")MultipartFile file8,
			@PathVariable Integer doc
			)throws Exception {
		System.out.println("Hii");
		
		//int a = Integer.parseInt(doc);
		Document d=new Document();
		d.setPhoto(file1.getBytes());
		d.setSignature(file2.getBytes());
		d.setPanCard(file3.getBytes());
		d.setAddressProof(file4.getBytes());
		d.setIncomeDocument(file5.getBytes());
		d.setAadharCard(file6.getBytes());
		d.setPropertyDocument(file7.getBytes());
		d.setBlankcheque(file8.getBytes());

		System.out.println("Id cust :"+doc);
		List<Document>l=hlsi.savedata(doc,d);
		l.add(d);
		
		return null;
		
	}
	@GetMapping(value = "/get")
	public List<Document> getFiles() {
		return hlsi.getDoc();
	}

}
