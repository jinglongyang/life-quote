package com.github.lifequote.mailman.service;

import com.github.lifequote.mailman.dao.CompanyDao;
import com.github.lifequote.mailman.dao.VendorAccountRepository;
import com.github.lifequote.mailman.domain.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private VendorAccountRepository vendorAccountRepository;

    @Autowired
    private CompanyDao cDao;

    @Autowired
    private transient PasswordEncoder passwordEncoder;
    private final String SALT = "life-quote";

    public CompanyEntity getByUsernameAndPassword(String username, String password) {
        List<CompanyEntity> vendors = vendorAccountRepository.findByUsernameAndPasswordQuery(username, passwordEncoder.encodePassword(password, SALT));
        if (!CollectionUtils.isEmpty(vendors)) {
            return vendors.get(0);
        }
        return null;
    }

    public CompanyEntity insertCompany(CompanyEntity company) {
        company.setPassword(passwordEncoder.encodePassword(company.getPassword(), SALT));
        return cDao.insertNewCompany(company);
    }
}
