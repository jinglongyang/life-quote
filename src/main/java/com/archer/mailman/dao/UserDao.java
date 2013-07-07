package com.archer.mailman.dao;

import com.archer.mailman.db.domain.UserEntity;

public interface UserDao {

	UserEntity createUser(UserEntity ue);
	
	UserEntity deleteUserByGuid(String ue);
	
	UserEntity updateUserEmail(String guid,String newEmail);
	
	UserEntity updateStatus(String guid, String status);
	
	boolean increaseUsedNumber(String guid);
	
	UserEntity getUserByGuid(String guid);

	UserEntity updateCell(String guid, String cell);
	
}
