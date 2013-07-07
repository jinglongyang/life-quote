package com.archer.mailman;

import com.github.lifequote.mailman.dao.CompanyDao;
import com.github.lifequote.mailman.domain.CompanyEntity;
import com.github.lifequote.mailman.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/ApplicationContext.xml"})
public class DaoTest {

    @Autowired
    CompanyDao cDao;

    @Autowired
    private CompanyService companyService;


    @Test
    public void insertTest() {
        CompanyEntity c = new CompanyEntity();
        c.setEmail(Arrays.asList(new String[]{"abc@gmail.com", "bcd@gmail.com"}));
        cDao.insertNewCompany(c);

    }

    @Test
    public void testGet() {
        CompanyEntity c = cDao.getByEmail("abc@gmail.com");
        System.out.println(c.toString());
    }

    @Test
    public void testUpdateEmail() {
        CompanyEntity c = cDao.getByEmail("abc@gmail.com");
        cDao.updateCompanyEmail(c.getGuid(), "abc@gmail.com", "abc1@gmail.com");
    }

    @Test
    public void insertPassword() {
        companyService.insertCompany(createCompany("a@b.com", "a@b.com"));
    }

    private CompanyEntity createCompany(String username, String password) {
        CompanyEntity company = new CompanyEntity();
        company.setUsername(username);
        company.setPassword(password);
        company.setEmail(Arrays.asList(new String[]{username}));
        return company;
    }

}
