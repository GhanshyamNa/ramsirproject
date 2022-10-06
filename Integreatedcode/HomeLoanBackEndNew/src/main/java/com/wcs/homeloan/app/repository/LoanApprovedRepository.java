package com.wcs.homeloan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.homeloan.app.model.LoanApprovedList;
@Repository
public interface LoanApprovedRepository extends JpaRepository<LoanApprovedList, Integer>
{

	LoanApprovedList findByLoanAid(int id);

}
