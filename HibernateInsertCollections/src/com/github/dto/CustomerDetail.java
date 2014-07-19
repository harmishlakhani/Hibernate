/**
 * This Entity represent the CUSTOMER_DETAIL table in DB.
 * We are storing addresses of each user and we want to capture all the 
 * addresses that user lived.
 * When we are not sure about no of addresses then we have to use collection.
 * Here Hibernate will store addresses in separate table and use foreign key
 * to link it with customer detail unlike Value Object which store data in 
 * same table.
 */
package com.github.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "CUSTOMER_DETAIL")
public class CustomerDetail {

	@Id
	private int customerId;
	private String firstName;
	private String lastName;
	
	@ElementCollection
	private Set<Address> addressList = new HashSet<Address>();
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(Set<Address> addressList) {
		this.addressList = addressList;
	}

}
