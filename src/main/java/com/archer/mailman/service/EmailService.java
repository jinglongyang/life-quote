package com.archer.mailman.service;

import javax.mail.Message;

import com.archer.mailman.dto.EmailTemplate;

public interface EmailService {

	 boolean sendEmail(EmailTemplate eTemplate);

	Message setMessage(EmailTemplate eTemplate);

	
	
	
}
