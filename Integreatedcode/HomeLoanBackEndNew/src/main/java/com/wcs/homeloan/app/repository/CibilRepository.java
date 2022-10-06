package com.wcs.homeloan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.homeloan.app.model.Cibil;

@Repository
public interface CibilRepository extends JpaRepository<Cibil, Integer> {
public	Cibil findByCibilId(int cib);


}
