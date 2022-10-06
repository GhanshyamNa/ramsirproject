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
@NoArgsConstructor
@AllArgsConstructor
public class PermanentAddress {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer paId;
private String streetName;
private String areaName;
private String cityName;
private String districtName;
private String stateName;
private Long pincodeNo;

}
