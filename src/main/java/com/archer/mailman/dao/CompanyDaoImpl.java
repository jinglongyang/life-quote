package com.archer.mailman.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.archer.mailman.common.util.CommonUtil;
import com.archer.mailman.db.domain.CompanyEntity;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	public CrudDao crud;

	@Override
	public CompanyEntity getByGuid(String guid) {
		return crud.getByField("guid", guid, CompanyEntity.class);
	}

	// to do...
	@Override
	public CompanyEntity getByEmail(String email) {
		return crud.getByField("email_list", email, CompanyEntity.class);
	}

	@Override
	public CompanyEntity getByName(String name) {
		return crud.getByField("name", name, CompanyEntity.class);
	}

	@Override
	public CompanyEntity insertNewCompany(CompanyEntity newCompany) {
		String time = CommonUtil.getCurrentTime();
		newCompany.setGuid(CommonUtil.generateUid());
		newCompany.setAddDate(time);
		newCompany.setModDate(time);
		return crud.save(newCompany);
	}

	@Override
	public CompanyEntity updateCompanyName(String guid, String newName) {
		String time = CommonUtil.getCurrentTime();
		CompanyEntity comp = getByGuid(guid);
		comp.setCompanyName(newName);
		comp.setModDate(time);
		return crud.save(comp);
	}

	@Override
	public CompanyEntity updateCompanyEmail(String guid, String oldEmail,
			String newEmail) {
		String time = CommonUtil.getCurrentTime();
		CompanyEntity comp = getByGuid(guid);
		List<String> emails = comp.getEmail();
		for (String email : emails) {
			if (email.equalsIgnoreCase(oldEmail)) {
				emails.set(emails.indexOf(oldEmail), newEmail);
			}
		}
		comp.setModDate(time);
		return crud.save(comp);
	}

	@Override
	public CompanyEntity addCompanyEmail(String guid, String newEmail) {
		String time = CommonUtil.getCurrentTime();
		CompanyEntity comp = getByGuid(guid);
		comp.getEmail().add(newEmail);
		comp.setModDate(time);
		return crud.save(comp);
	}

	@Override
	public CompanyEntity updateCategory(String guid, String oldCategory,
			String newCategory) {
		String time = CommonUtil.getCurrentTime();
		CompanyEntity comp = getByGuid(guid);
        comp.setCategory(newCategory);
		comp.setModDate(time);
		return crud.save(comp);
	}

//	@Override
//	public CompanyEntity addCategoryForCompany(String guid, String category) {
//		String time = CommonUtil.getCurrentTime();
//		CompanyEntity comp = getByGuid(guid);
//		comp.getCategory().add(category);
//		comp.setModDate(time);
//		return crud.save(comp);
//	}

	@Override
	public CompanyEntity updateAccountType(String guid, String accountType) {
		String time = CommonUtil.getCurrentTime();
		CompanyEntity comp = getByGuid(guid);
		comp.setAccountType(accountType);
		comp.setModDate(time);
		return crud.save(comp);
	}

	@Override
	public CompanyEntity updateActiveDate(String guid, String newDate) {
		String time = CommonUtil.getCurrentTime();
		CompanyEntity comp = getByGuid(guid);
		comp.setActiveDate(newDate);
		comp.setModDate(time);
		return crud.save(comp);
	}

	@Override
	public CompanyEntity updateStatus(String guid, String status) {
		String time = CommonUtil.getCurrentTime();
		CompanyEntity comp = getByGuid(guid);
		comp.setActiveDate(status);
		comp.setModDate(time);
		return crud.save(comp);
	}

	@Override
	public CompanyEntity removeEmail(String guid, String emailToRemove) {
		String time = CommonUtil.getCurrentTime();
		CompanyEntity comp = getByGuid(guid);
		List<String> emails = comp.getEmail();
		for (String email : emails) {
			if (email.equalsIgnoreCase(emailToRemove)) {
				emails.remove(emailToRemove);
			}
		}
		comp.setModDate(time);
		return crud.save(comp);
	}

//	@Override
//	public CompanyEntity removeCategory(String guid, String category) {
//		String time = CommonUtil.getCurrentTime();
//		CompanyEntity comp = getByGuid(guid);
//		List<String> cateList = comp.getCategory();
//		for (String cate : cateList) {
//			if (cate.equalsIgnoreCase(category)) {
//				cateList.remove(category);
//			}
//		}
//		comp.setModDate(time);
//		return crud.save(comp);
//	}

	@Override
	public boolean removeCompany(String guid) {
		crud.remove("guid", guid, CompanyEntity.class);
		return true;
	}
	
	@Override
	public CompanyEntity updatePassword(String guid, String newPassword){		
		String time = CommonUtil.getCurrentTime();
		CompanyEntity comp = getByGuid(guid);
		comp.setPassword(newPassword);
		comp.setModDate(time);
		return crud.save(comp);
	}
	
	
	

}
