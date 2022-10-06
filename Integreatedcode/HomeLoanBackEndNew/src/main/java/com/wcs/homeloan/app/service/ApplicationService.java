package com.wcs.homeloan.app.service;

import java.util.List;

import com.wcs.homeloan.app.model.Applicant;
import com.wcs.homeloan.app.model.Customer;
import com.wcs.homeloan.app.model.Document;
import com.wcs.homeloan.app.model.EmailSender;




public interface ApplicationService {
	
public Applicant saveApplicantDataApp(Integer customerId, Applicant a);



public Customer saveApplicantData(Customer a);	

public Iterable<Customer> geteApplicantData();



public List<Document> getDoc();

public void sendmail(EmailSender e);

public void sendEmailWithAttachement(EmailSender e) throws Exception;

public List<Document> savedata(Integer id, Document d);





























}
