package com.github.lifequote.mailman.dao;

import com.github.lifequote.mailman.domain.UserEntity;

public interface UserDao {

	UserEntity createUser(UserEntity ue);
	
	UserEntity deleteUserByGuid(String ue);
	
	UserEntity updateUserEmail(String guid,String newEmail);
	
	UserEntity updateStatus(String guid, String status);
	
	boolean increaseUsedNumber(String guid);
	
	UserEntity getUserByGuid(String guid);

	UserEntity updateCell(String guid, String cell);
	
}
