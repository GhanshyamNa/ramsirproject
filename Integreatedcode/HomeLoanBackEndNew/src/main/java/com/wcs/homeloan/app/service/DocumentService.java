package com.wcs.homeloan.app.service;

import java.util.List;


import com.wcs.homeloan.app.model.Applicant;
import com.wcs.homeloan.app.model.Document;

public interface DocumentService {

	

	public List<Applicant> findAll();

	public Document updateverifivation(Integer docId, Document app);

	public Document findSingleDocument(int docId);
	
	//********dummy
	Applicant getsingelappdata(String applicationId);


}
