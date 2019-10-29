package com.jwt.ags.model;

public class Credential {

	private User user;
	private String login;
	private String password;
	private Integer statusCode;
	private String returnMessage;
	
	public Credential() {
	}

	public Credential(String returnMessage, Integer statusCode) {
		super();
		this.statusCode = statusCode;
		this.returnMessage = returnMessage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

}
