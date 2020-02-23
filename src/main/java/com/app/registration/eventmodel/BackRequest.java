package com.app.registration.eventmodel;

public class BackRequest {
	private String Validation;
	private String SetOfReward;
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
	public String getValidation() {
		return Validation;
	}
	public void setValidation(String validation) {
		Validation = validation;
	}
	public String getSetOfReward() {
		return SetOfReward;
	}
	public void setSetOfReward(String setOfReward) {
		SetOfReward = setOfReward;
	}

}
