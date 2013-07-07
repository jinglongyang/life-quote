package com.github.lifequote.mailman.email.domain;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Aaron Yang
 */
public class Item {
    private String name;
    private String defaultValue;
    private boolean required = false;
    private boolean messageResource = false;
    private String messageCode;

    /**
     * @return the name
     */
    @XmlAttribute(required = true)
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the defaultValue
     */
    @XmlAttribute
    public String getDefaultValue() {
        if (defaultValue == null) {
            defaultValue = "";
        }
        return defaultValue;
    }

    /**
     * @param defaultValue the defaultValue to set
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * @return the required
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * @param required the required to set
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

    /**
     * @return the messageResource
     */
    public boolean isMessageResource() {
        return messageResource;
    }

    /**
     * @param messageResource the messageResource to set
     */
    public void setMessageResource(boolean messageResource) {
        this.messageResource = messageResource;
    }

    /**
     * @return the messageCode
     */
    public String getMessageCode() {
        return messageCode;
    }

    /**
     * @param messageCode the messageCode to set
     */
    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }
}
