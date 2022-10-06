package com.wcs.homeloan.app.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.wcs.homeloan.app.model.EmailSender;
import com.wcs.homeloan.app.model.*;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(EmailSender e)
	{
	
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		
		mailMessage.setFrom(e.getFromEmail());
		mailMessage.setTo(e.getToEmail());
		mailMessage.setSubject(e.getSubject());
		mailMessage.setText(e.getTextMessage());
		
		javaMailSender.send(mailMessage);
		System.out.println("Email Send successfully");
		
		
	}


public String sendEmailAttachement(EmailSender eml) {
	  MimeMessage message=javaMailSender.createMimeMessage();
  
  try { 
	  MimeMessageHelper helper=new MimeMessageHelper(message,true);
	  
  helper.setFrom(eml.getFromEmail());
  helper.setTo(eml.getToEmail());
  helper.setSubject(eml.getSubject()); 
  helper.setText(eml.getTextMessage());
  
  FileSystemResource file=new FileSystemResource("C:\\demonop.pdf");
  helper.addAttachment(file.getFilename(), file); 
  javaMailSender.send(message);
  
  } catch (MessagingException e) {
	  throw new MailParseException(e); }
  
  
  
  return "emailsend"; } 
 
}