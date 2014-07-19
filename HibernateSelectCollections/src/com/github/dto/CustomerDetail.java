/**
 * This Entity represent the CUSTOMER_DETAIL table in DB.
 * Here we have addresses as a collection for customer table.
 * 
 * We have 2 type of loading.
 * 1. Lazy(default by hibernate) :
 * 			when you request for collection property then only it
 * 			fetches data from DB otherwise return it from proxy object.
 * 2. Eager : 
 * 			it will load all the data whethet we request for it or not.
 */
package com.github.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name = "CUSTOMER_DETAIL")
public class CustomerDetail {

	@Id
	private int customerId;
	private String firstName;
	private String lastName;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "CUSTOMER_ADDRESS_WITHOUT_PK", joinColumns = @JoinColumn(name = "CUSTOMER_ID"))
	private Set<Address> addressSet = new HashSet<Address>();
	
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "CUSTOMER_ADDRESS_WITH_PK", joinColumns = @JoinColumn(name = "CUSTOMER_ID"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type = "long"))
	private Collection<Address> addressList = new ArrayList<Address>();
	
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

	public Set<Address> getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set<Address> addressSet) {
		this.addressSet = addressSet;
	}

	public Collection<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(Collection<Address> addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		return "CustomerDetail [customerId=" + customerId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", addressSet="
				+ addressSet.toString() + ", addressList=" + addressList.toString() + "]";
	}

}
