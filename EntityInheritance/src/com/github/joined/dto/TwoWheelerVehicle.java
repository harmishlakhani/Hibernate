/**
 * This class represents TwoWheelerVehicle Entity.
 * It inherits from Vehicle Entity.
 */
package com.github.joined.dto;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "TWO_WHEELER_VEHICLE_3")
public class TwoWheelerVehicle extends Vehicle{

	@Column(name = "STREEING_HANDLE")
	private String streeingHandle;

	public String getStreeingHandle() {
		return streeingHandle;
	}

	public void setStreeingHandle(String streeingHandle) {
		this.streeingHandle = streeingHandle;
	}

}
