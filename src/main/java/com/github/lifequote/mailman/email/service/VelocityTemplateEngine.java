/**
 *
 */
package com.github.lifequote.mailman.email.service;

import com.github.lifequote.mailman.email.domain.EmailTemplate;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.Locale;
import java.util.Map;

/**
 * @author Aaron Yang
 */
public class VelocityTemplateEngine implements TemplateEngine {
    private static Logger logger = LoggerFactory.getLogger(VelocityTemplateEngine.class);
    private VelocityEngine velocityEngine;

    /**
     * @param velocityEngine the velocityEngine to set
     */
    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    @Override
    public String processTemplateIntoString(EmailTemplate emailTemplate, Map<String, Object> model, Locale locale) {
        StringBuilder templateFileName = new StringBuilder("templates/velocity/");
        templateFileName.append(emailTemplate.getTemplateFile());
        if (locale != null) {
            templateFileName.append("_").append(locale.toString());
        }
        templateFileName.append(".vm");
        logger.info("The template file name is {}.", templateFileName.toString());
        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateFileName.toString(), "UTF-8", model);
    }
}
