package com.github.lifequote.mailman.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.lifequote.mailman.domain.EmailList;

@Repository
public class EmailListDaoImpl implements EmailListDao {

	@Autowired
	CrudDao crud;

	@Override
	public void addToEmailList(String category, List<String> emailList) {
		EmailList target = getByCategory(category);
		if (target != null) {
			target.getEmailList().addAll(emailList);
			crud.save(target);
		} else {
			EmailList eList = new EmailList();
			eList.setCategory(category);
			eList.setEmailList(emailList);
			createEmailList(eList);
		}
	}

	@Override
	public void changeCategoryName(String category, String newCategory) {
		EmailList target = getByCategory(category);
		if (target != null) {
			target.setCategory(newCategory);
			crud.save(target);
		}
	}

	@Override
	public void removeFromEmailList(String category, String email) {
		EmailList target = getByCategory(category);
		target.getEmailList().remove(email);
		crud.save(target);
	}

	@Override
	public EmailList getByCategory(String category) {
		return crud.getByField("categories", category, EmailList.class);
	}

	@Override
	public void createEmailList(EmailList emailList) {
		if (getByCategory(emailList.getCategory()) == null) {
			crud.save(emailList);
		} else {
			addToEmailList(emailList.getCategory(), emailList.getEmailList());
		}
	}
}
