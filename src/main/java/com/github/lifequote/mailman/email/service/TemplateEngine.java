/**
 *
 */
package com.github.lifequote.mailman.email.service;

import com.github.lifequote.mailman.email.domain.EmailTemplate;

import java.util.Locale;
import java.util.Map;

/**
 * @author Aaron Yang
 */
public interface TemplateEngine {
    /**
     * @param emailTemplate
     * @param model
     * @return
     */
    public String processTemplateIntoString(EmailTemplate emailTemplate, Map<String, Object> model, Locale locale);
}
