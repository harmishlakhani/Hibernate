/**
 * This class represents Address Entity.
 * Here we have many to one relationship between Address and Client.
 * Each address has associated client.
 */
package com.github.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ADDRESS_DETAILS")
public class Address {

	@Id @GeneratedValue
	@Column(name = "ADDRESS_ID")
	private int addressId;
	
	@Column(name = "STREET_NAME")
	private String streetName;
	
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
