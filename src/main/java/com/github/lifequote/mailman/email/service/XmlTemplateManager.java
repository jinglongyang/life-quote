/**
 *
 */
package com.github.lifequote.mailman.email.service;

import com.github.lifequote.mailman.email.domain.EmailTemplate;
import com.github.lifequote.mailman.email.domain.EmailTemplates;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.oxm.GenericUnmarshaller;
import org.springframework.util.CollectionUtils;

import javax.xml.transform.stream.StreamSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aaron Yang
 */
public class XmlTemplateManager implements EmailTemplateManager, InitializingBean {
    private Resource resource;
    private GenericUnmarshaller unmarshaller;
    private final Map<String, EmailTemplate> templates = new HashMap<String, EmailTemplate>();

    @Override
    public EmailTemplate retrive(String id) {
        return templates.get(id);
    }

    /**
     * @param resource the resource to set
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    /**
     * @param unmarshaller the unmarshaller to set
     */
    public void setUnmarshaller(GenericUnmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        StreamSource streamSource = new StreamSource(resource.getInputStream());
        EmailTemplates emailTemplates = (EmailTemplates) unmarshaller.unmarshal(streamSource);
        List<EmailTemplate> templates = emailTemplates.getTemplates();
        if (!CollectionUtils.isEmpty(templates)) {
            for (EmailTemplate template : templates) {
                this.templates.put(template.getId(), template);
            }
        }
    }
}
