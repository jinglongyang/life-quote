package com.archer.mailman.dao;

public interface CrudDao {

	/*
	 * insert or update
	 */
	<T> T save(T dbObject);

	/*
	 * remove by guid..
	 */
	<T> T remove(String fieldName, String fieldValue, Class<T> entityClass);

	//get
	<T>T getByField(String fieldName, String fieldValue, Class<T> t);

    
}
