package com.example.demo.model;

public class MemberDetailModel {

	private int memberId;

	private String name;

	private String email;

	private String address;

	private long phoneNumber;
	
	private boolean outstandhingFee;
	
	private boolean status;

	private String bookId;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public boolean isOutstandhingFee() {
		return outstandhingFee;
	}

	public void setOutstandhingFee(boolean outstandhingFee) {
		this.outstandhingFee = outstandhingFee;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
