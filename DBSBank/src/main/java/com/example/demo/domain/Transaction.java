package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reciversdata")
public class Transaction {

	@Id
	private String BIC;
	private String Rec_Institution_Name;

	public String getBIC() {
		return BIC;
	}

	public void setBIC(String bIC) {
		BIC = bIC;
	}

	public String getRec_Institution_Name() {
		return Rec_Institution_Name;
	}

	public void setRec_Institution_Name(String rec_Institution_Name) {
		Rec_Institution_Name = rec_Institution_Name;
	}
}
