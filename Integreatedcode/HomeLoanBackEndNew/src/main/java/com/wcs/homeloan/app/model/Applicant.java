package com.wcs.homeloan.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String applicationId;
	private String education;
	private String nationality;
	private String profession;
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	@OneToOne(cascade = CascadeType.ALL)
	private CurrentAddress caddr;
	@OneToOne(cascade = CascadeType.ALL)
	private PermanentAddress paddr;
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDetails loanDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private PropertyDetails propertyDetails;
	@OneToOne(cascade = CascadeType.ALL)	
	private CustomerBankDetails bankDetails;	
	private String verificationResult="Pending";
	

	

}
