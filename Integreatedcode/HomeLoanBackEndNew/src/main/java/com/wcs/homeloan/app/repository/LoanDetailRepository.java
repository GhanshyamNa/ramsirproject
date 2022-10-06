package com.wcs.homeloan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.homeloan.app.model.LoanDetails;
@Repository
public interface LoanDetailRepository extends JpaRepository<LoanDetails , Integer>
{
	
}
