package com.wcs.homeloan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.homeloan.app.model.Applicant;
@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, String> {
   Applicant findByCustomerCustomerId(Integer id);
   public Applicant findByApplicationId(String applicationId);//Gunjan
}
