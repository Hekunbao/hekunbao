package com.hkb.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="userAccount",nullable=false,updatable=false)
	private String userAccount;
	@Column(name="username",nullable=false)
	private String username;
	@Column(name="password",nullable=false,updatable=true)
	private String password;
	@Column(name="email",nullable=false,updatable=true)
	private String email;
	@Column(name="createDate",nullable=false,updatable=false)
	private LocalDate createDate;
	
	
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
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
