package com.github.lifequote.mailman.service;

import javax.mail.Message;

import com.github.lifequote.mailman.dto.EmailTemplate;

public interface EmailService {

	 boolean sendEmail(EmailTemplate eTemplate);

	Message setMessage(EmailTemplate eTemplate);

	
	
	
}
