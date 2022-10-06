package com.wcs.homeloan.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.homeloan.app.model.Sanction;
import com.wcs.homeloan.app.service.SanctionService;

@RestController
public class SantionController 
{
@Autowired
SanctionService ss;

@PostMapping(value="/generatesanctionLoan/{applicationId}")
public Sanction postdata(@PathVariable String applicationId,Sanction s )
{
	return ss.getsanctiondata(applicationId,s);
}
}
