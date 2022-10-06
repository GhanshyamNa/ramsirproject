package com.wcs.homeloan.app.service;
import java.util.List;

import javax.mail.MessagingException;

import com.wcs.homeloan.app.model.Applicant;
import com.wcs.homeloan.app.model.CurrentAddress;
import com.wcs.homeloan.app.model.Customer;
import com.wcs.homeloan.app.model.EmailSender;
import com.wcs.homeloan.app.model.LoanApprovedList;
import com.wcs.homeloan.app.model.LoanDetails;
import com.wcs.homeloan.app.model.PermanentAddress;
import com.wcs.homeloan.app.model.SanctionLetter;

public interface CreditManageService {
	
	Customer save(Customer cust);

	CurrentAddress save(CurrentAddress caddr);

	PermanentAddress savePAddress(PermanentAddress paddr);

	LoanDetails saveLoanData(LoanDetails loan);

	Applicant saveApplicant(Applicant ap);

	List<Applicant> getAllData();

	LoanApprovedList saveLALData(LoanApprovedList lal);

	List<LoanApprovedList> getLoanApprovedList();

	LoanApprovedList getLoanApprovedList(int id);

	SanctionLetter saveSanction(int id, LoanApprovedList lalist, SanctionLetter snl);

	List<SanctionLetter> getSanctionLetterData();

	SanctionLetter getDataForLetter(int id);

	void sendEmailWithAttachment(EmailSender es) throws MessagingException;
}
