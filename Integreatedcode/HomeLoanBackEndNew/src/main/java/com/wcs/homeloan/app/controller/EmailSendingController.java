package com.wcs.homeloan.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.homeloan.app.model.EmailSender;
import com.wcs.homeloan.app.service.ApplicationService;



@RestController
@RequestMapping("/api")
public class EmailSendingController {

	@Autowired
	ApplicationService hls;

	@Value("${spring.mail.username}")
	private String fromEmail;

	@PostMapping(value = "/sendEmail")
	public String sendmail(@RequestBody EmailSender e) {
		e.setFromEmail(fromEmail);
		try {
			hls.sendmail(e);

		} catch (Exception e2) {
			return "Eamil Not Send";
		}
		return "Email Send Successfully";
	}

	@PostMapping(value = "/sendEmailWithAttachement")
	public String sendEmailWithAttachement(@RequestBody EmailSender e) {
		e.setFromEmail(fromEmail);
		try {
			hls.sendEmailWithAttachement(e);

		} catch (Exception e2) {
			return "Eamil Not Send";
		}
		return "Email Send Successfully";
	}
}
