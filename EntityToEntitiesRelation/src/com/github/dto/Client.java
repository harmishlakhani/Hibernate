/**
 * This Entity represent Client Entity.
 * Here we have one to many relationship between Client and Address.
 * Each client has multiple addresses.
 * We have bidirectional relationship by combining OneToMany and ManyToOne
 * Here instead of creating separate table hibernate maps relationship by
 * inserting client id in address entity.
 */
package com.github.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "CLIENT_DETAILS")
public class Client {

	@Id @GeneratedValue
	@Column(name = "CLIENT_ID")
	private int clientId;
	
	@Column(name = "CLIENT_NAME")
	private String clientName;
	
	@OneToMany(mappedBy = "client")
	private Collection<Address> addressList = new ArrayList<Address>();
	
	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Collection<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(Collection<Address> addressList) {
		this.addressList = addressList;
	}

}
