package com.workspace.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*This class will be used to talk with UI*/
public class CreateUserModel {
	
	@NotNull(message = "username cannot be null")
	@Size(min = 7)
	private String username;
	
	@NotNull(message = "password cannot be null")
	@Size(min = 8,max = 12)
	private String password;
	
	@NotNull(message = "email cannot be null")
	@Email
	private String email;
	
	public CreateUserModel() {
		super();
	}
	
	public CreateUserModel(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
