package com.archer.mailman.dto;

import org.springframework.stereotype.Component;

@Component 
public class EmailTemplate {

	private String toEmails;
	private String subject;
	private String text;

	public String getToEmails() {
		return toEmails;
	}

	public void setToEmails(String toEmails) {
		this.toEmails = toEmails;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "EmailTemplate [toEmails=" + toEmails + ", subject=" + subject
				+ ", text=" + text + "]";
	}
}
