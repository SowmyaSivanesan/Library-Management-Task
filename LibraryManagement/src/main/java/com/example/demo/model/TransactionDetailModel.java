package com.example.demo.model;

import java.sql.Date;

public class TransactionDetailModel {
	
	private int transactionId;
	
	private int bookId;
	
	private int memberId;
	
	private Date issueDate;
	
	private Date returnDate;
	
	private boolean outstandhingFee;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public boolean isOutstandhingFee() {
		return outstandhingFee;
	}

	public void setOutstandhingFee(boolean outstandhingFee) {
		this.outstandhingFee = outstandhingFee;
	}
	
	

}
