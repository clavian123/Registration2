package com.app.registration.model;

public class LoginResponse {
	boolean loginSuccess;
	boolean usernameIsValid;
	
	public boolean isLoginSuccess() {
		return loginSuccess;
	}
	public void setLoginSuccess(boolean loginSuccess) {
		this.loginSuccess = loginSuccess;
	}
	public boolean isUsernameIsValid() {
		return usernameIsValid;
	}
	public void setUsernameIsValid(boolean usernameIsValid) {
		this.usernameIsValid = usernameIsValid;
	}
	
}
