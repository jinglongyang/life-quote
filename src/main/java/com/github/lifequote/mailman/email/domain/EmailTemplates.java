/**
 * 
 */
package com.github.lifequote.mailman.email.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Aaron Yang
 * 
 */
@XmlRootElement(name = "templates")
public class EmailTemplates {
    private List<EmailTemplate> templates;

    /**
     * @return the templates
     */
    @XmlElement(name = "template")
    public List<EmailTemplate> getTemplates() {
        return templates;
    }

    /**
     * @param templates
     *            the templates to set
     */
    public void setTemplates(List<EmailTemplate> templates) {
        this.templates = templates;
    }
}
