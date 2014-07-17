/**
 * This class represents ADDRESS table. It contains several annotations.
 * 1. @Basic : Default java to sql datatype mappings(optional and default)
 * 2. @Transient : Ignore that field while performing operations
 * 3. @Temporal : to specify in which date format date field needs to be persisted (Default is DATETIME).
 * 4. @Lob : When we have large amount of data like large string(String -> CLOB, byte[] -> BLOB).				  
 *
 */
package com.github.dto;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@Basic()
	private int addressId;
	
	@Lob
	private String addressLine;
	
	@Transient
	private String addressLine2;
	
	@Temporal(TemporalType.DATE)
	private Date dateInsterted;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public Date getDateInsterted() {
		return dateInsterted;
	}

	public void setDateInsterted(Date dateInsterted) {
		this.dateInsterted = dateInsterted;
	}
	
}
