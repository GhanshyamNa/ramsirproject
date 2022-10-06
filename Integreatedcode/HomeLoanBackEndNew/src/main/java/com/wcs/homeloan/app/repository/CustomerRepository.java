package com.wcs.homeloan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.homeloan.app.model.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

public	Customer findByCustomerId(Integer customerId);


}
