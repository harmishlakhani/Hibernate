/**
 * This Entity represent the CUSTOMER_DETAIL table in DB.
 * We are storing addresses of each user and we want to capture all the 
 * addresses that user lived.
 * When we are not sure about no of addresses then we have to use collection.
 * Here Hibernate will store addresses in separate table and use foreign key
 * to link it with customer detail unlike Value Object which store data in 
 * same table.
 * 
 * By default hibernate provides table name as entityName_collectionField
 * and foreignKey name as entityName_primaryKeyField.
 * If you want to change this you can use @JoinTable annotation as shown in
 * below example.
 * 
 * We have taken 2 collection 
 *  1. Set : if we don't need primary key
 *  2. List : if we need index/primary key
 *  
 *  For List we need to give some specification
 *  about name of primary key and type.
 *  We don't need a separate property in Address class
 *  to represent primary key. It is someting that hibernate
 *  will insert using annotation.
 */
package com.github.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
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
	
	@ElementCollection
	@JoinTable(name = "CUSTOMER_ADDRESS_WITHOUT_PK", joinColumns = @JoinColumn(name = "CUSTOMER_ID"))
	private Set<Address> addressSet = new HashSet<Address>();
	
	@ElementCollection
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

}
