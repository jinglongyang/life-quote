package com.github.lifequote.mailman.domain;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "email_list")
public class EmailList {

	@Id
	private ObjectId id;
	private String category;
	private String area;
	private List<String> emailList;

	public ObjectId getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<String> emailList) {
		this.emailList = emailList;
	}
	
	

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "EmailList [id=" + id + ", category=" + category + ", area="
				+ area + ", emailList=" + emailList + "]";
	}



}
