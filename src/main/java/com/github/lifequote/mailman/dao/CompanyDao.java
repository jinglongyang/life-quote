package com.github.lifequote.mailman.dao;

import com.github.lifequote.mailman.domain.CompanyEntity;

public interface CompanyDao {
	// get...
	CompanyEntity getByGuid(String guid);
	CompanyEntity getByName(String name);
	CompanyEntity getByEmail(String email);

	// insert...
	CompanyEntity insertNewCompany(CompanyEntity newCompany);


	// update....
	CompanyEntity updateCompanyName(String guid, String newName);

	CompanyEntity updateCompanyEmail(String guid, String oldEmail, String newEmail);

	CompanyEntity addCompanyEmail(String guid, String newEmail);

	CompanyEntity updateCategory(String guid, String oldCategory, String newCategory);


	CompanyEntity updateAccountType(String guid, String accountType);

	// remove company email...
	CompanyEntity removeEmail(String guid, String emailToRemove);
//	CompanyEntity removeCategory(String guid, String category);
	CompanyEntity updateActiveDate(String guid, String newDate);
	CompanyEntity updateStatus(String guid, String status);
	//remove...
	boolean removeCompany(String guid);
	CompanyEntity updatePassword(String guid, String newPassword);



}
