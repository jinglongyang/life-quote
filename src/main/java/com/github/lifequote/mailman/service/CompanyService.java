package com.github.lifequote.mailman.service;


import com.github.lifequote.mailman.domain.CompanyEntity;

/**
 *
 */
public interface CompanyService {
    CompanyEntity getByUsernameAndPassword(String username, String password);

    CompanyEntity insertCompany(CompanyEntity company);
}
