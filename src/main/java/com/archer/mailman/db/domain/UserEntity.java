package com.archer.mailman.db.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection="users")
public class UserEntity {
	
    @Id
    private ObjectId id;
    @Field ("guid")
	private String guid;
    private String status;
	private String email;
    @Field ("system_used_number")
	private int usedNumber=1;
    @Field ("cell_number")
	private String cell;
	private String zip;
	@Field("add_date")
	private String addDate;
	@Field("mod_date")
	private String modDate;
	


	public ObjectId getId() {
		return id;
	}
	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUsedNumber() {
		return usedNumber;
	}

	public void setUsedNumber(int usedNumber) {
		this.usedNumber = usedNumber;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}


	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", guid=" + guid + ", status=" + status
				+ ", email=" + email + ", usedNumber=" + usedNumber + ", cell="
				+ cell + ", zip=" + zip + ", addDate=" + addDate + ", modDate="
				+ modDate + "]";
	}



}
