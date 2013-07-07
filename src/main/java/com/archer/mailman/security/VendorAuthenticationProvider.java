package com.archer.mailman.security;

import com.archer.mailman.db.domain.CompanyEntity;
import com.archer.mailman.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author: ayang
 */
@Component
public class VendorAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    private final static Logger logger = LoggerFactory.getLogger(VendorAuthenticationProvider.class);
    @Autowired
    private CompanyService companyService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
    }

    @Override
    public UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        String password = (String) authentication.getCredentials();
        if (!StringUtils.hasText(password)) {
            logger.warn("Username {}: no password provided", username);
            throw new BadCredentialsException("Please enter password");
        }

        CompanyEntity companyEntity = companyService.getByUsernameAndPassword(username, password);
        if (companyEntity == null) {
            logger.warn("Username {}, password {}: username and password not found", username, password);
            throw new BadCredentialsException("Invalid Username/Password");
        }

        return new User(username, password, true, true, true, true, Arrays.asList(new SimpleGrantedAuthority("ROLE_VENDOR")));
    }
}
