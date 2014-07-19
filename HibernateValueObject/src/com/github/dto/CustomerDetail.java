/**
 * This Entity represent the CUSTOMER_DETAIL table in DB.
 * It includes Address as a Value Object in CUSTOMER_DETAIL table.
 * @Embedded is optional here. @Embeddable is enough. 
 * 
 * If you want more than one address then also you can do that but you need to give unique
 * column name for each attribute of Value Object.
 * Ex : address represents home address
 * 		officeAddress represents office address
 * 
 * Annotation : @AttributeOverrides contains each overridden attribute detail as a list
 * 				@AttributeOverride contains single attribute detail
 */
package com.github.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
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
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name = "streetLine", column = @Column(name = "OFC_STREET_LINE")),
	@AttributeOverride(name = "city", column = @Column(name = "OFC_CITY")),
	@AttributeOverride(name = "country", column = @Column(name = "OFC_COUNTRY")),
	@AttributeOverride(name = "pincode", column = @Column(name = "OFC_PINCODE"))
	})
	private Address officeAddress;
	
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

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
}
