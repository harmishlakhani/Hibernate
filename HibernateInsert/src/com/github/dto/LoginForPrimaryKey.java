/**
 * This Entity represent the LOGIN table in DB.
 * Here we are not passing any primary key from our side.
 * We will use one that is automatically generated by hibernate.
 * Annotation used : @Id @GeneratedValue
 */
package com.github.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "LOGIN_TEMP")
public class LoginForPrimaryKey {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String username;
	private String password;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	
}
