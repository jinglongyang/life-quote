package com.archer.mailman.dao;

import java.util.List;

import com.archer.mailman.db.domain.EmailList;

public interface EmailListDao {

	EmailList getByCategory(String category);

	void createEmailList(EmailList emailList);

	void addToEmailList(String category, List<String> emailList);

	void changeCategoryName(String category, String newCategory);

	void removeFromEmailList(String category, String email);

}
