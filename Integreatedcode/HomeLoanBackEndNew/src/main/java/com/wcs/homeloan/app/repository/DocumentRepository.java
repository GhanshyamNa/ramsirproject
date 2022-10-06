package com.wcs.homeloan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.homeloan.app.model.Document;
@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
public Document findByDocId(int docid);
}

