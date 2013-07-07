/**
 *
 */
package com.github.lifequote.mailman.email.service;

import com.github.lifequote.mailman.email.domain.EmailTemplate;
import com.github.lifequote.mailman.email.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Aaron Yang
 */
public abstract class AbstractEmailService implements EmailService {
    private static Logger logger = LoggerFactory.getLogger(SpringEmailService.class);

    private TemplateEngine templateEngine;
    private EmailTemplateManager emailTemplateManager;
    private MessageSource messageSource;

    /**
     * @param messageSource the messageSource to set
     */
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * @param emailTemplateManager the emailTemplateManager to set
     */
    public void setEmailTemplateManager(EmailTemplateManager emailTemplateManager) {
        this.emailTemplateManager = emailTemplateManager;
    }

    /**
     * @param templateEngine the templateEngine to set
     */
    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public void sendEmail(String emailTemplate, String[] to, Map<String, Object> parameters) {
        sendEmail(emailTemplateManager.retrive(emailTemplate), to, parameters, null);
    }

    @Override
    public void sendEmail(String emailTemplate, String[] to, Map<String, Object> parameters, Locale locale) {
        Assert.notNull(emailTemplate, "Email template id must be not null.");
        logger.info("The email template is {}.", emailTemplate);
        sendEmail(emailTemplateManager.retrive(emailTemplate), to, parameters, locale);

    }

    @Override
    public void sendEmail(EmailTemplate emailTemplate, String[] to, Map<String, Object> parameters, Locale locale) {
        Assert.notNull(emailTemplate, "Email template must be not null.");
        List<Item> items = emailTemplate.getItems();
        Map<String, Object> model = getMessages(items, parameters, locale);

        String content = templateEngine.processTemplateIntoString(emailTemplate, model, locale);
        if (logger.isDebugEnabled()) {
            logger.debug(content);
        }

        doSend(emailTemplate.getFrom(), emailTemplate.getSubject(), content, to, emailTemplate.isHtml());
    }

    public void sendEmail(EmailTemplate emailTemplate, String[] to, Map<String, Object> parameters) {
        sendEmail(emailTemplate, to, parameters, null);
    }

    @Override
    public void sendEmail(final String from, final String subject, final String content, final String[] to, boolean html) {
        doSend(from, subject, content, to, html);
    }

    abstract protected void doSend(final String from, final String subject, final String content, final String[] to,
                                   final boolean html);

    /**
     * @param items
     * @return
     */
    protected Map<String, Object> getMessages(List<Item> items, Map<String, Object> parameters, Locale locale) {
        Map<String, Object> model = new HashMap<>();
        if (!CollectionUtils.isEmpty(items)) {
            for (Item item : items) {
                if (item.isMessageResource()) {
                    model.put(item.getName(), messageSource.getMessage(item.getMessageCode(), null, locale));
                }
                model.put(item.getName(), getItemValue(parameters, item));
            }
        }
        return model;
    }

    /**
     * @param parameters
     * @param item
     * @return
     */
    protected String getItemValue(Map<String, Object> parameters, Item item) {
        if (CollectionUtils.isEmpty(parameters)) {
            return item.getDefaultValue();
        } else {
            String value = (String) parameters.get(item.getName());
            return value == null ? item.getDefaultValue() : value;
        }
    }
}
