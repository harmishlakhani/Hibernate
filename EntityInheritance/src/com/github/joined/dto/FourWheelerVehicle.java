/**
 * This class represents FourWheelerVehicle Entity.
 * It inherits from Vehicle Entity.
 */
package com.github.joined.dto;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "FOUR_WHEELER_VEHICLE_3")
public class FourWheelerVehicle extends Vehicle{

	@Column(name = "STREEING_WHEEL")
	private String streeingWheel;

	public String getStreeingWheel() {
		return streeingWheel;
	}

	public void setStreeingWheel(String streeingWheel) {
		this.streeingWheel = streeingWheel;
	}
	
}
