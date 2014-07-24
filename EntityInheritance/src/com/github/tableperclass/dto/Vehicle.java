/**
 * This class represents Vehicle Entity.
 * Here we have two child classes which inherits Vehicle class.
 * 
 * We have use TABLE_PER_CLASS strategy in which hibernate will
 * insert data of all classes in separate table.
 * 
 * Here hibernate will insert all the attributes that are inherited
 * by child class in child class table.
 */
package com.github.tableperclass.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "VEHICLE_2")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
