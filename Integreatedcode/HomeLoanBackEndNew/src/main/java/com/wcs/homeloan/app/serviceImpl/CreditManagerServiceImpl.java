package com.wcs.homeloan.app.serviceImpl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wcs.homeloan.app.model.Applicant;
import com.wcs.homeloan.app.model.CurrentAddress;
import com.wcs.homeloan.app.model.Customer;
import com.wcs.homeloan.app.model.EmailSender;
import com.wcs.homeloan.app.model.LoanApprovedList;
import com.wcs.homeloan.app.model.LoanDetails;
import com.wcs.homeloan.app.model.PermanentAddress;
import com.wcs.homeloan.app.model.SanctionLetter;
import com.wcs.homeloan.app.repository.ApplicantRepository;
import com.wcs.homeloan.app.repository.CurrentAddressRepository;
import com.wcs.homeloan.app.repository.CustomerRepository;
import com.wcs.homeloan.app.repository.LoanApprovedRepository;
import com.wcs.homeloan.app.repository.LoanDetailRepository;
import com.wcs.homeloan.app.repository.PermanentAddressRepository;
import com.wcs.homeloan.app.repository.SanctionLetterRepository;
import com.wcs.homeloan.app.service.CreditManageService;

@Service
public class CreditManagerServiceImpl implements CreditManageService
{
	@Autowired
	CustomerRepository hlr;
	@Autowired
	CurrentAddressRepository car;
	@Autowired
	PermanentAddressRepository par;
	@Autowired
	LoanDetailRepository ldr;
	@Autowired
	ApplicantRepository ar;
	@Autowired
	LoanApprovedRepository lar;
	@Autowired
	SanctionLetterRepository slr;
	
	@Autowired
	JavaMailSender sender;
	
	@Override
	public Customer save(Customer cust) 
	{
		Customer c = hlr.save(cust);
		return c;
	}

	@Override
	public CurrentAddress save(CurrentAddress caddr) 
	{
		CurrentAddress ca = car.save(caddr);
		return ca;
	}

	@Override
	public PermanentAddress savePAddress(PermanentAddress paddr) 
	{
		PermanentAddress pa = par.save(paddr);
		return pa;
	}

	@Override
	public LoanDetails saveLoanData(LoanDetails loan) 
	{
		LoanDetails l = ldr.save(loan);
		return l;
	}

	@Override
	public Applicant saveApplicant(Applicant ap) 
	{
		Applicant apl = ar.save(ap);
		return apl;
	}

	@Override
	public List<Applicant> getAllData() 
	{
		List<Applicant> app = ar.findAll();
		return app;
	}

	@Override
	public LoanApprovedList saveLALData(LoanApprovedList lal) 
	{
		LoanApprovedList Loanal = lar.save(lal);
		return Loanal;
	}

	@Override
	public List<LoanApprovedList> getLoanApprovedList() 
	{
		List<LoanApprovedList> lal = lar.findAll();
		return lal;
	}

	@Override
	public LoanApprovedList getLoanApprovedList(int id) 
	{
		LoanApprovedList ap = lar.findByLoanAid(id);
		return ap;
	}

	@Override
	public SanctionLetter saveSanction(int id, LoanApprovedList lalist, SanctionLetter snl) 
	{
		LoanApprovedList lal = lar.findByLoanAid(id);
		System.out.println(lal.getLoanDetails().getTenureofLoan());
		snl.setLal(lal);
		
		System.out.println("Loan Required : "+lalist.getLoanDetails().getTotalLoanRequired());
		System.out.println("Loan Sanctioned : "+lalist.getSanction().getSanctionedAmount());
		System.out.println("Loan Tenure : "+lalist.getLoanDetails().getTenureofLoan());
		System.out.println("Interest Rate : "+lalist.getSanction().getRateofInterest());
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println(formatter.format(date));
		
		double principal = lalist.getSanction().getSanctionedAmount();
		double rate = lalist.getSanction().getRateofInterest();
		double time = lalist.getLoanDetails().getTenureofLoan();
		rate=rate/(12*100); 
        time=time*12; 
		double monthlyemi = (principal*rate*Math.pow(1+rate,time))/(Math.pow(1+rate,time)-1);
		double totalemi = (monthlyemi*time);
		double totalamount = (principal+totalemi);
		
		System.out.println(monthlyemi);
		System.out.println(totalemi);
		System.out.println(totalamount);
		
		snl.setMonthlyEMIAmount(monthlyemi);
		snl.setPrincipalAmount(principal);
		snl.setSanctionDate(formatter.format(date));
		snl.setTotalInterest(totalemi);
		snl.setTotalAmount(totalamount);
		
		if(lalist.getSanction().getSanctionedAmount() == null)
		{
			snl.setStatus("Loan Declined");
		}
		else
		{
			snl.setStatus("Loan Sanctioned");
		}
		
		return slr.save(snl);
	}

	@Override
	public List<SanctionLetter> getSanctionLetterData() 
	{
		List<SanctionLetter> sl = slr.findAll();
		return sl;
	}

	@Override
	public SanctionLetter getDataForLetter(int id) 
	{
		return slr.findBySanctionId(id);
	}

	@Override
	public void sendEmailWithAttachment(EmailSender es) throws MessagingException {
		
			MimeMessage msg=sender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(msg,true);
			helper.setTo(es.getToEmail());
			helper.setFrom(es.getFromEmail());
			helper.setSubject(es.getSubject());
			helper.setText(es.getTextMessage());
			
			FileSystemResource file=new FileSystemResource(new File("C://Users/PratikSingh/Downloads/sanction-letter.pdf"));
			
			helper.addAttachment(file.getFilename(),file);
			sender.send(msg);
			
		}
		
	}

