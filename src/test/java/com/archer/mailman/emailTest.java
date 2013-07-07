package com.archer.mailman;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.archer.mailman.dto.EmailTemplate;
import com.archer.mailman.service.EmailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/ApplicationContext.xml"})
public class emailTest {

	@Autowired
	@Qualifier("emailService")
	EmailService es;
	@Autowired
	EmailTemplate et;
	
	@Test
	public void test() {
		et.setSubject("whatever");
		et.setText("zhen xin buzhi dao");
		et.setToEmails("yuzhao86@gmail.com,nanzhao136@gmail.com");
		es.sendEmail(et);
		
//		System.out.println(env.UserName);
	}

}
