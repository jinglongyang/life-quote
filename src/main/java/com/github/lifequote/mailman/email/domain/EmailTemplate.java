package com.github.lifequote.mailman.email.domain;

import org.springframework.util.StringUtils;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author Aaron Yang
 */
@XmlRootElement(name = "template")
public class EmailTemplate {
    private String id;
    private String description;
    private String templateFileName;

    private String from;
    private String subject;

    private List<Item> items;
    private boolean html = false;

    /**
     * @return the id
     */
    @XmlID
    @XmlAttribute(required = true)
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    @XmlAttribute(required = true)
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the templateFileName
     */
    @XmlAttribute
    public String getTemplateFileName() {
        return templateFileName;
    }

    /**
     * @param templateFileName the templateFileName to set
     */
    public void setTemplateFileName(String templateFileName) {
        this.templateFileName = templateFileName;
    }

    /**
     * @return the from
     */
    @XmlElement(required = true)
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the subject
     */
    @XmlElement(required = true)
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the items
     */
    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * @return the html
     */
    @XmlAttribute
    public boolean isHtml() {
        return html;
    }

    /**
     * @param html the html to set
     */
    public void setHtml(boolean html) {
        this.html = html;
    }

    public String getTemplateFile() {
        return StringUtils.hasLength(templateFileName) ? templateFileName : id;
    }
}
