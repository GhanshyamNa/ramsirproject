package com.wcs.homeloan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.homeloan.app.model.Document;

@Repository
public interface Cust_Doc_Repository extends JpaRepository<Document, Integer> {

}
