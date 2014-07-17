/**
 * This Entity represent the Country table in DB.
 * Table name and fields name are same as Class and field names.
 * This is default behavior if we doesn't provide any additional annoations.  
 */
package com.github.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {

	@Id
	private int countryId;
	private String countryDesc;
	private String isoCode;
	
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryDesc() {
		return countryDesc;
	}
	public void setCountryDesc(String countryDesc) {
		this.countryDesc = countryDesc;
	}
	public String getIsoCode() {
		return isoCode;
	}
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}
	
}
