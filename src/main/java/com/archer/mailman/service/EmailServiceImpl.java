package com.archer.mailman.service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.archer.mailman.constant.Environment;
import com.archer.mailman.dao.CompanyDao;
import com.archer.mailman.dto.EmailTemplate;
import com.archer.mailman.factory.SessionFactory;

@Service("emailService")
public class EmailServiceImpl implements EmailService{

	@Autowired
	CompanyDao cdao;
	
	
	@Async
	@Override
	public boolean sendEmail(EmailTemplate eTemplate) {
		
		
		
		try {
			Message message = setMessage(eTemplate);
			Transport.send(message);
			System.out.println("Done");
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Message setMessage(EmailTemplate eTemplate) {
		Message message = new MimeMessage(SessionFactory.getSession());
		try {
			message.setFrom(new InternetAddress(Environment.UserName));

			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(eTemplate.getToEmails()));
			message.setSubject(eTemplate.getSubject());
			message.setText(eTemplate.getText());
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return message;
	}

}
