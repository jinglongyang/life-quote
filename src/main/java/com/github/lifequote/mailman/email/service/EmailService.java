package com.github.lifequote.mailman.email.service;

import com.github.lifequote.mailman.email.domain.EmailTemplate;

import java.util.Locale;
import java.util.Map;

/**
 * @author Aaron Yang
 */
public interface EmailService {

    public void sendEmail(String emailTemplate, final String[] to, final Map<String, Object> parameters, Locale locale);

    public void sendEmail(EmailTemplate emailTemplate, final String[] to, final Map<String, Object> parameters,
                          Locale locale);

    public void sendEmail(String from, String subject, String content, final String[] to, boolean html);

}
