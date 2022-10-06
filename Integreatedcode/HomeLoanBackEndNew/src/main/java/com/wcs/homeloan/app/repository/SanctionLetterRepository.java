package com.wcs.homeloan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.homeloan.app.model.SanctionLetter;

@Repository
public interface SanctionLetterRepository extends JpaRepository<SanctionLetter, Integer>
{

	SanctionLetter findBySanctionId(int id);

}
