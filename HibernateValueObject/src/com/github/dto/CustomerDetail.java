/**
 * This Entity represent the CUSTOMECUSTOMER_DETAILR table in DB.
 * It includes Address as a Value Object in CUSTOMER_DETAIL table.
 * @Embedded is optional here. @Embeddable is enough. 
 */
package com.github.dto;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "CUSTOMER_DETAIL")
public class CustomerDetail {

	@Id
	private int customerId;
	private String firstName;
	private String lastName;
	
	@Embedded
	private Address address;
	
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
