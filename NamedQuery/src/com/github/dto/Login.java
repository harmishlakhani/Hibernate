/**
 * This Entity represent the LOGIN table in DB. 
 * Here we have used named query which we can refer from anywhere in application.
 */
package com.github.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

@Entity(name = "LOGIN")
@NamedQuery(name = "Login.byId", query = "from LOGIN where customerId = ?")
@NamedNativeQuery(name = "Login.byName", query = "select * from LOGIN where username = ?", resultClass = Login.class)
public class Login {
	
	@Id
	@GeneratedValue
	@Column(name = "CUSTOMER_ID")
	private int customerId;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
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
	
	@Override
	public String toString() {
		return "Login [customerId=" + customerId + ", username=" + username
				+ "]";
	}
	
}
