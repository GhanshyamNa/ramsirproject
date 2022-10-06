package com.wcs.homeloan.app.serviceImpl;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.wcs.homeloan.app.model.EmailSender;
import com.wcs.homeloan.app.model.Ledger;
import com.wcs.homeloan.app.repository.LedgerRepository;
import com.wcs.homeloan.app.service.LedgerService;

@Service
public class LeadgerServiceImpl implements LedgerService {
	@Autowired
	LedgerRepository lr;
	@Autowired
	JavaMailSender sender;

	@Override
	public List<Ledger> getLedger() {
		return lr.findAll();
	}

	@Override
	public Ledger addLedger(Ledger l) {
		return lr.save(l);
	}

	public void email(EmailSender e) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(e.getToEmail());
		msg.setFrom(e.getFromEmail());
		msg.setText(e.getTextMessage());
		msg.setSubject(e.getSubject());
		sender.send(msg);
		System.out.println("mail Send..!");

	}

	public void sendEmailWithAttachment(EmailSender e) throws MessagingException {

		MimeMessage msg1 = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg1, true);
		helper.setTo(e.getToEmail());
		helper.setFrom(e.getFromEmail());
		helper.setSubject(e.getSubject());
		helper.setText(e.getTextMessage());

		FileSystemResource file = new FileSystemResource(
				new File("C:\\Users\\rames\\Documents\\Inheritance_Rules.docx"));
		helper.addAttachment(file.getFilename(), file);
		sender.send(msg1);

	}
}
