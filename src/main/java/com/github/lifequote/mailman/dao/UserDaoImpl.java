package com.github.lifequote.mailman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.github.lifequote.mailman.util.CommonUtils;
import com.github.lifequote.mailman.domain.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	CrudDao crud;

	@Override
	public UserEntity createUser(UserEntity ue) {
		String time = CommonUtils.getCurrentTime();
		ue.setGuid(CommonUtils.generateUid());
		ue.setAddDate(time);
		ue.setModDate(time);
		ue.setUsedNumber(1);
		return crud.save(ue);
	}

	@Override
	public UserEntity deleteUserByGuid(String guid) {
		return crud.remove("guid", guid, UserEntity.class);
	}

	@Override
	public UserEntity updateCell(String guid, String cell) {
		String time = CommonUtils.getCurrentTime();
		UserEntity ue = getUserByGuid(guid);
		ue.setCell(cell);
		ue.setModDate(time);
		return crud.save(ue);
	}

	@Override
	public UserEntity updateUserEmail(String guid, String newEmail) {
		String time = CommonUtils.getCurrentTime();
		UserEntity ue = getUserByGuid(guid);
		ue.setEmail(newEmail);
		ue.setModDate(time);
		return crud.save(ue);
	}

	@Override
	public boolean increaseUsedNumber(String guid) {
		String time = CommonUtils.getCurrentTime();
		UserEntity ue = getUserByGuid(guid);
		ue.setUsedNumber(ue.getUsedNumber() + 1);
		ue.setModDate(time);
		crud.save(ue);
		return true;
	}

	@Override
	public UserEntity getUserByGuid(String guid) {
		return crud.getByField("guid", guid, UserEntity.class);
	}

	@Override
	public UserEntity updateStatus(String guid, String status) {
		String time = CommonUtils.getCurrentTime();
		UserEntity ue = getUserByGuid(guid);
		ue.setStatus(status);
		ue.setModDate(time);
		return crud.save(ue);
	}

}
