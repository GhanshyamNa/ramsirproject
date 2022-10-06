package com.wcs.homeloan.app.controller;

//import javax.mail.internet.MimeMessage;
//import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;

import com.wcs.homeloan.app.model.Cibil;
import com.wcs.homeloan.app.model.*;
import com.wcs.homeloan.app.model.EmailSender;
import com.wcs.homeloan.app.repository.ApplicantRepository;
import com.wcs.homeloan.app.repository.CibilRepository;
import com.wcs.homeloan.app.repository.CustomerRepository;
import com.wcs.homeloan.app.serviceImpl.EmailSenderService;


@RestController
public class EmailSenderController {
	@Autowired
	EmailSenderService ess;

	@Autowired
	CibilRepository cibilRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ApplicantRepository applicantRepository;
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	//-------------------------------------Mail the CIBIL score-----------------------------------------------------------------	
	@PostMapping(value = "/sendCibilScoreEmail/{customerId}")// http://localhost:2233/sendemail
	public String cibilEmailSend(@RequestBody EmailSender eml,@PathVariable ("customerId") Integer customerId)
	{
		eml.setFromEmail(fromEmail);
		
		Customer customerData=customerRepository.findByCustomerId(customerId);
		Cibil cibilData=cibilRepository.getById(customerId);
				
		eml.setToEmail(customerData.getEmail());
		eml.setSubject("CIBIL Score");
		if(cibilData.getCibilScore()>=750) 
		{
			eml.setTextMessage("Your CIBIL score is "+cibilData.getCibilScore()+
							"\nYou are eligible to apply for loan.");
		}
		else 
		{
			eml.setTextMessage("Your CIBIL score is "+cibilData.getCibilScore()+
					"\nMinimum required CIBIL score is 750."+"\nCurretly,you are not eligible to apply for loan.");
		}	
		
		try {
			ess.sendEmail(eml);
			return "Emailsend";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "Email can not sent";
		}
	}}	
//-------------------------------------Verification mail-----------------------------------------------------------------
/*	@PostMapping(value = "/sendDocVerifyStatusEmail/{applicationId}")// http://localhost:2233/sendemail
	public String docEmailSend(@RequestBody EmailSender eml,@PathVariable ("applicationId") String applicationId)
	{
		eml.setFromEmail(fromEmail);
		Applicant data= applicantRepository.findByApplicationId(applicationId);
		//String verificationResult=data.getDocumentup().getVerificationResult();
		eml.setToEmail(data.getCustomer().getEmail());
		eml.setSubject("Document Verification");
		if(data.getCibil().getCibilScore()>=750) 
		{
			eml.setTextmsg("Your CIBIL score is "+data.getCibil().getCibilScore()+
							"\nYour documents has been verified and approved for the further process."+
							"\nSoon you will be notified regarding the Sanctioning proccess.");
		}
		else 
		{
			eml.setTextmsg("Your CIBIL score is "+data.getCibil().getCibilScore()+
					"\nMinimum required CIBIL score is 750."+"\nCurretly,you are not eligible to apply for loan.");
		}	
		
		try {
			ess.sendEmail(eml);
			return "Emailsend";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "Email can not sent";
		}
	}

@PostMapping(value = "/sendemailwithattch") 
public String sendEmailAttachement(@RequestBody EmailSender eml)
{
eml.setFromEmail(fromEmail); 

return ess.sendEmailAttachement(eml); 
}}*/