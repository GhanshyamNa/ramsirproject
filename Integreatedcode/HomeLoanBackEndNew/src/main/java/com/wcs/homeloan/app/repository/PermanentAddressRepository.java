package com.wcs.homeloan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.homeloan.app.model.PermanentAddress;
@Repository
public interface PermanentAddressRepository extends JpaRepository<PermanentAddress, Integer>
{

	
}
