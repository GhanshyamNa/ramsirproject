package com.wcs.homeloan.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBankDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bankId;
	private Long caccountNo;
	private String ifscCode;
	private String bankName;
	private String micrcode;
	private String branchAddress;

}
