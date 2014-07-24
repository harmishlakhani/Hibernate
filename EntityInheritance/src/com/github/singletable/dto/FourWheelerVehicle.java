/**
 * This class represents FourWheelerVehicle Entity.
 * It inherits from Vehicle Entity.
 */
package com.github.singletable.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FOUR_WHEELER_VEHICLE")
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
