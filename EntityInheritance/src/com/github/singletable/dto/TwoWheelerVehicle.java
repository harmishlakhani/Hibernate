/**
 * This class represents TwoWheelerVehicle Entity.
 * It inherits from Vehicle Entity.
 */
package com.github.singletable.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TWO_WHEELER_VEHICLE")
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
