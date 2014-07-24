/**
 * This class represents Vehicle Entity.
 * Here we have two child classes which inherits Vehicle class.
 * 
 * We have use SINGLE_TABLE strategy in which hibernate will
 * insert data of all subclasses in base class entity table.
 * 
 * Hibernate will use Discriminator column in order to
 * differentiate 2 objects because sometimes following 
 * scenario can happen.
 * Child class object only set properties of Base class.
 * In this case it is difficult to identify whether object
 * is of base class or child class.
 */
package com.github.singletable.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "VEHICLE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "VEHICLE_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

	@Id @GeneratedValue
	@Column(name = "VEHICLE_ID")
	private int vehicleId;
	
	@Column(name = "VEHICLE_NAME")
	private String vehicleName;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}
