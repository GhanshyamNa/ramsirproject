package com.wcs.homeloan.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcs.homeloan.app.Exception.DocumentNotFoundException;
import com.wcs.homeloan.app.model.Applicant;
import com.wcs.homeloan.app.model.Document;
import com.wcs.homeloan.app.repository.ApplicantRepository;
import com.wcs.homeloan.app.repository.DocumentRepository;
import com.wcs.homeloan.app.service.DocumentService;


@Service
public class DocumentServiceIMPL implements DocumentService {
@Autowired
ApplicantRepository ar;

@Autowired
DocumentRepository dr;
	
	@Override
	public List<Applicant> findAll() {
		
		return ar.findAll();
	}
	
	@Override
	public Document updateverifivation(Integer ad, Document app) {
		app.setDocId(ad);
		return dr.save(app);
	}

	

	@Override
	public Document findSingleDocument(int docId) {
		Document d=null;
	
		try {
		
		 d= dr.findByDocId(docId);
		}
		catch(Exception e)
		{
			throw new DocumentNotFoundException("Documents not uploaded for this ID.");
		}
		return d;
	}
	//*******dummy
	@Override
	public Applicant getsingelappdata(String applicationId) {
		
		return ar.findByApplicationId(applicationId);
	}
	
	
}
