package com.example.demo.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Transact")
public class CustomerTransactions {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private UUID transactionId;
	@CreationTimestamp
	@Column(name = "Timestamp")
	private Date date;
	@Column(name = "Sender_Acc_number")
	private long senderAccno;
	@Column(name = "Sender_Name")
	private String senderName;
	@Column(name = "Receiver_Acc_number")
	private long receiverAccno;
	@Column(name = "Receiver_Name")
	private String receiverName;
	@Column(name = "Transfered_Amount")
	private double transferAmt;
	@Column(name = "Transaction_Type")
	private String txnType;
	@Column(name = "Message_Type")
	private String msgType;
	@Column(name = "Result")
	private String result;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public UUID getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
	}

	public long getSenderAccno() {
		return senderAccno;
	}

	public void setSenderAccno(long senderAccno) {
		this.senderAccno = senderAccno;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public long getReceiverAccno() {
		return receiverAccno;
	}

	public void setReceiverAccno(long receiverAccno) {
		this.receiverAccno = receiverAccno;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public double getTransferAmt() {
		return transferAmt;
	}

	public void setTransferAmt(double transferAmt) {
		this.transferAmt = transferAmt;
	}
}
