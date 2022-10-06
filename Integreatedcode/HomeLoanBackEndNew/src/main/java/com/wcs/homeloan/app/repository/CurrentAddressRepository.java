package com.wcs.homeloan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.homeloan.app.model.CurrentAddress;
@Repository
public interface CurrentAddressRepository extends JpaRepository<CurrentAddress, Integer>
{

}
