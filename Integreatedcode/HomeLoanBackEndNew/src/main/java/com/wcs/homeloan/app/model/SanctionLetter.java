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
public class SanctionLetter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sanctionId;
	private String sanctionDate;
	private String status;
	private Double monthlyEMIAmount;
	private Double principalAmount;
	private Double totalInterest;
	private Double totalAmount;
	@OneToOne(cascade = CascadeType.ALL)
	private LoanApprovedList lal;

}
