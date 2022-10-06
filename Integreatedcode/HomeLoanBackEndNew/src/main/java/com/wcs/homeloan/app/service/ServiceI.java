package com.wcs.homeloan.app.service;

import java.util.Optional;

import com.wcs.homeloan.app.model.LoanApprovedList;

public interface ServiceI {

	public Iterable<LoanApprovedList> getData();

	LoanApprovedList saveData(LoanApprovedList loanApprovesList);

	public Optional<LoanApprovedList> getloanbyid(int id);

	

}
