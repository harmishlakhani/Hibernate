/**
 * This Entity represent the STATE table in DB.
 * Table name and fields name are as per the "name" field of annotations
 * We have overridden the default behavior of hibernate.  
 */
package com.github.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="STATE")
public class State {

	@Id
	@Column(name = "STATE_ID")
	int stateId;
	
	@Column(name = "STATE_NAME")
	String name;
	
	@Column(name = "STATE_ABBREVIATION")
	String abbreviation;
	
	@Column(name = "COUNTRY_ID")
	int countryId;

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	
}
