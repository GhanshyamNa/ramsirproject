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
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer docId;
	private byte[] photo;
	private byte[] signature;
	private byte[] panCard;
	private byte[] addressProof;
	private byte[] incomeDocument;
	private byte[] aadharCard;
	private byte[] propertyDocument;
	private byte[] blankcheque;
   @OneToOne(cascade = CascadeType.ALL)
     private Applicant applicationId;

}
