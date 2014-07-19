/**
 * This class represents ADDRESS value object.
 * It is not a separate table but it contains fields that are added to some 
 * other table which include this class as a Value Object.  				  
 * Annotation used : @Embeddable
 * You can use @Column as well in order to configure column names.
 */
package com.github.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name = "STREET_LINE")
	private String streetLine;
	@Column(name = "CITY")
	private String city;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "PINCODE")
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
