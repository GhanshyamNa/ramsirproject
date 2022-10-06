package com.wcs.homeloan.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.homeloan.app.model.EmailSender;
import com.wcs.homeloan.app.model.LoanApprovedList;

import com.wcs.homeloan.app.model.SanctionLetter;
import com.wcs.homeloan.app.service.CreditManageService;


@CrossOrigin("*")
@RestController
public class CreditManagerController 
{
	@Autowired
	CreditManageService hls;
	

	
	@PostMapping("/addLoanApprovedList")
	public LoanApprovedList addData(@RequestBody LoanApprovedList lal)
	{
		LoanApprovedList loanal = hls.saveLALData(lal);
		return loanal;
	}
	
	@GetMapping("/getLoanApprovedList")
	public List<LoanApprovedList> getLoanApprovedListData()
	{
		List<LoanApprovedList> lal = hls.getLoanApprovedList();
		return lal;
	}
	
	@GetMapping("/getLoanApprovedCustomerList/{loanAid}")
	public LoanApprovedList getLoanApprovedListData(@PathVariable("loanAid") int id)
	{
		LoanApprovedList lal = hls.getLoanApprovedList(id);
		return lal;
	}
	
	@PostMapping("/calculateEMI/{loanAid}")
	public SanctionLetter saveData(@PathVariable("loanAid") int id,@RequestBody LoanApprovedList lalist) 
	{
		SanctionLetter snl = new SanctionLetter();
		return hls.saveSanction(id,lalist,snl);	
	}
	
	@GetMapping("/getAllSanctionLetterData")
	public List<SanctionLetter> getAllSanctionLetterData()
	{
		List<SanctionLetter> sl = hls.getSanctionLetterData();
		return sl;
	}
	
	@GetMapping("/getSanctionLetterData/{sanctionId}")
	public SanctionLetter getDataForLetter(@PathVariable("sanctionId") int id)
	{
		return hls.getDataForLetter(id);
	}
	

	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@PostMapping(value="/emailsendwithattachment")
	public String emailsendwithattachment(@RequestBody EmailSender es)
	{
		es.setFromEmail(fromEmail);
		System.out.println(es.getFromEmail());
		System.out.println(es.getToEmail());
		System.out.println(es.getSubject());
		System.out.println(es.getTextMessage());
		//System.out.println(es.getAttachment());
		System.out.println(es.getClass());
		try {
			hls.sendEmailWithAttachment(es);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Email can not be send";
		}
		return "Email send Successfully";
	}

	
}
