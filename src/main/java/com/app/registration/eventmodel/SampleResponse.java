package com.app.registration.eventmodel;

public class SampleResponse {
	private String TransactionTypeCode;
	private String loginName;
	private String cifCode;

	public String getCifCode() {
		return cifCode;
	}

	public void setCifCode(String cifCode) {
		this.cifCode = cifCode;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getTransactionTypeCode() {
		return TransactionTypeCode;
	}

	public void setTransactionTypeCode(String TransactionTypeCode) {
		this.TransactionTypeCode = TransactionTypeCode;
	}
	
	
}
