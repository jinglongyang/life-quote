package com.archer.mailman.service;


import com.archer.mailman.db.domain.CompanyEntity;

/**
 *
 */
public interface CompanyService {
    CompanyEntity getByUsernameAndPassword(String username, String password);

    CompanyEntity insertCompany(CompanyEntity company);
}
