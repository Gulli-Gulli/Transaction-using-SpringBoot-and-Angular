package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banklogs")
public class Bank {
	public String toString() {
		return "Bank [customer_id=" + customer_id + ", account_holder_name=" + account_holder_name
				+ ", clear_balance_inr_credit=" + clear_balance_inr_credit + ", transfer_type=" + transfer_type
				+ ", overdraft=" + overdraft + "]";
	}

	@Id
	private Long customer_id;
	private String account_holder_name;
	private int clear_balance_inr_credit;
	private String transfer_type;
	private String overdraft;

	public Bank() {
		super();
	}

	public Bank(Long customer_id) {
		super();
		this.customer_id = customer_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getAccount_holder_name() {
		return account_holder_name;
	}

	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}

	public int getClear_balance_inr_credit() {
		return clear_balance_inr_credit;
	}

	public void setClear_balance_inr_credit(int clear_balance_inr_credit) {
		this.clear_balance_inr_credit = clear_balance_inr_credit;
	}

	public String getTransfer_type() {
		return transfer_type;
	}

	public void setTransfer_type(String transfer_type) {
		this.transfer_type = transfer_type;
	}

	public String getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(String overdraft) {
		this.overdraft = overdraft;
	}
}
