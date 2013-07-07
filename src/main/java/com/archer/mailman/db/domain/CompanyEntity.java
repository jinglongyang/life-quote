package com.archer.mailman.db.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "company")
public class CompanyEntity {
    @Id
    private ObjectId id;
    private String guid;
    private String username;
    @Field("company_name")
    private String companyName;
    @Field("password")
    private String password;
    @Field("categories")
    private String category;
    @Field("email_list")
    private List<String> email;
    @Field("account_type")
    private String accountType;
    @Field("active_date")
    private String activeDate;
    private String status;
    @Field("add_date")
    private String addDate;
    @Field("mod_date")
    private String modDate;

    public ObjectId getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getModDate() {
        return modDate;
    }

    public void setModDate(String modDate) {
        this.modDate = modDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CompanyEntity [id=" + id + ", guid=" + guid + ", companyName="
                + companyName + ", password=" + password + ", category="
                + category + ", email=" + email + ", accountType="
                + accountType + ", activeDate=" + activeDate + ", status="
                + status + ", addDate=" + addDate + ", modDate=" + modDate
                + "]";
    }


}
