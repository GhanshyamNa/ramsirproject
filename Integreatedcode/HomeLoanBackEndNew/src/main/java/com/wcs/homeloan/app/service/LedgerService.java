package com.wcs.homeloan.app.service;

import java.util.List;

import javax.mail.MessagingException;

import com.wcs.homeloan.app.model.EmailSender;
import com.wcs.homeloan.app.model.Ledger;

public interface LedgerService {

	public List<Ledger> getLedger();

	public Ledger addLedger(Ledger l);

	public void email(EmailSender e);

	public void sendEmailWithAttachment(EmailSender e) throws MessagingException;

}
