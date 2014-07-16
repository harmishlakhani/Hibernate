/**
 * This Entity represent the LOGIN table in DB.
 * Table name and fields name are as per the "name" field of annotations
 * We have overridden the default behavior of hibernate.
 * Here we use annotation on getter instead of field which cause data to be inserted as
 * return by getter method of each field.  
 */
package com.github.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "LOGIN")
public class Login {

	private int customerId;
	private String username;
	private String password;
	
	@Id
	@Column(name = "CUSTOMER_ID")
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Column(name = "USERNAME")
	public String getUsername() {
		return username + "from getter";
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "PASSWORD")
	public String getPassword() {
		return password + "from getter";
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
