package com.wcs.homeloan.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcs.homeloan.app.model.LoanApprovedList;
import com.wcs.homeloan.app.repository.LoanApprovedRepository;
import com.wcs.homeloan.app.service.ServiceI;

@Service
public class ServiceImpl implements ServiceI {

	@Autowired
	LoanApprovedRepository lr;

	@Override
	public LoanApprovedList saveData(LoanApprovedList loanApprovesList) {

		return lr.save(loanApprovesList);
	}

	@Override
	public Iterable<LoanApprovedList> getData() {

		return lr.findAll();
	}

	@Override
	public Optional<LoanApprovedList> getloanbyid(int id) {

		return lr.findById(id);
	}

}
