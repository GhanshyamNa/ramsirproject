package com.wcs.homeloan.app.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcs.homeloan.app.repository.ApplicantRepository;
import com.wcs.homeloan.app.repository.SanctionRepository;

@Service
public class SanctionServiceImpl {

	@Autowired
	SanctionRepository sr;
	@Autowired
	ApplicantRepository ar;
	
	}


