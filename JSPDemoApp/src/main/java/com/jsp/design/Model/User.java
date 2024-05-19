package com.jsp.design.Model;

public class User {

	private String UserId;
	private String Password;

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", Password=" + Password + "]";
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}
