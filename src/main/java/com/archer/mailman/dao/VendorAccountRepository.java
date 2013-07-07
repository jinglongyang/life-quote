package com.archer.mailman.dao;

import com.archer.mailman.db.domain.CompanyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ayang
 */
@Repository
public interface VendorAccountRepository extends MongoRepository<CompanyEntity, String> {
    CompanyEntity findByUsername(final String username);

    @Query("{ 'username' : ?0, 'password' : ?1 }")
    List<CompanyEntity> findByUsernameAndPasswordQuery(final String username, final String password);
}
