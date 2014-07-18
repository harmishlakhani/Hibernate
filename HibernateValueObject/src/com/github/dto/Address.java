/**
 * This class represents ADDRESS value object.
 * It is not a separate table but it contains fields that are added to some 
 * other table which include this class as a Value Object.  				  
 * Annotation used : @Embeddable
 */
package com.github.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String streetLine;
	private String city;
	private String country;
	private String pincode;
	
	public String getStreetLine() {
		return streetLine;
	}
	public void setStreetLine(String streetLine) {
		this.streetLine = streetLine;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}
