package com.workspace.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -8643365933265756906L;
	
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false,length = 12)
	private String username;
	@Column(nullable = false,length = 120,unique = true)
	private String email;
	@Column(nullable = false,unique = true)
	private String userid;
	@Column(nullable = false,unique = true)
	private String encryptedpassword;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEncryptedpassword() {
		return encryptedpassword;
	}
	public void setEncryptedpassword(String encryptedpassword) {
		this.encryptedpassword = encryptedpassword;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
