package com.wcs.homeloan.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.wcs.homeloan.app.model.Applicant;
import com.wcs.homeloan.app.model.Customer;
import com.wcs.homeloan.app.model.Document;
import com.wcs.homeloan.app.model.EmailSender;
import com.wcs.homeloan.app.repository.ApplicantRepository;
import com.wcs.homeloan.app.repository.Cust_Doc_Repository;
import com.wcs.homeloan.app.repository.CustomerRepository;
import com.wcs.homeloan.app.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	Cust_Doc_Repository cdr;
	@Autowired
	CustomerRepository cr;
	@Autowired
	ApplicantRepository ar;	
	
	//Applicant data

	public Applicant saveApplicantDataApp(Integer customerId,Applicant a) {
	Customer	c=cr.findByCustomerId(customerId);
	a.setCustomer(c);
	String prevId=null;
	try {
	
		List<Applicant> app	= ar.findAll();
		Applicant appl = app.stream().reduce((first,second)->second).orElse(null);
		if(appl!=null)
		{
				prevId=appl.getApplicationId();
		}
		else
		{
			prevId="WCS00000";
		}
	} catch (Exception e) {
			prevId="WCS00000";
	}		
	
	String data=prevId.replace("WCS", "");
	int num = Integer.parseInt(data);
	num = num+1;
	String nextID = getNumberFormat(num);
		
		a.setApplicationId(nextID);
	return ar.save(a);
}

private static String getNumberFormat(int number) {
	String numberData="WCS";
	if(number>=1 && number<=9)
	{
		numberData=numberData+"0000"+number;
	}
	else if(number>=10 && number<=99)
	{
		numberData=numberData+"000"+number;
	} 
	else if(number>=100 && number<=999)
	{
		numberData=numberData+"00"+number;
	} 
	else if(number>=1000 && number<=9999)
	{
		numberData=numberData+"0"+number;
	} 
	else if(number>=10000 && number<=99999)
	{
		numberData=numberData+""+number;
	} 
	return numberData;
}
	//Customer-data 

	public Customer saveApplicantData(Customer a) {
		
		return cr.save(a);
	}
	
	public Iterable<Customer> geteApplicantData() {
		Iterable<Customer>l=cr.findAll();
		return l;
	}
	//Document Upload configuration

	public List<Document> getDoc() {
		List<Document>l=cdr.findAll();
		return l;
	}
	
	// Email Sending Service configuration
	@Autowired
	JavaMailSender sender;

	public void sendmail(EmailSender e) {

		SimpleMailMessage massage = new SimpleMailMessage();
		massage.setFrom(e.getFromEmail());
		massage.setTo(e.getToEmail());
		massage.setSubject(e.getSubject());
		massage.setText(e.getTextMessage());
		sender.send(massage);

	}

	public void sendEmailWithAttachement(EmailSender e) throws Exception {

		MimeMessage msg = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setFrom(e.getFromEmail());
		helper.setTo(e.getToEmail());
		helper.setSubject(e.getSubject());
		helper.setText(e.getTextMessage());

		FileSystemResource file = new FileSystemResource("E:\\abc.pdf");
		helper.addAttachment(file.getFilename(), file);
		sender.send(msg);

	}






	@Override
	public List<Document> savedata(Integer id, Document d) {
		Applicant apid=ar.findByCustomerCustomerId(id);
		
		d.setApplicationId(apid);
		List<Document> list = cdr.findAll();
		
		return list;
	}

	













	

	

	

}
