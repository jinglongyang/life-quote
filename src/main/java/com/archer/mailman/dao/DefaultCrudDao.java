package com.archer.mailman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class DefaultCrudDao implements CrudDao{
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public <T> T getByField(String fieldName, String fieldValue, Class<T> t) {
		Query q=new Query (Criteria.where (fieldName).is (fieldValue));
		return mongoTemplate.findOne(q, t);
	}
	

	@Override
	public <T> T save(T dbObject) {
		mongoTemplate.save(dbObject);
		return dbObject;
	}


	@Override
	public <T> T remove(String fieldName, String fieldValue, Class<T> entityClass) {
		Query q=new Query (Criteria.where (fieldName).is (fieldValue));
		return mongoTemplate.findAndRemove(q, entityClass);

	}



	
	

	
	
	
}
