/**
 * This class represents Vehicle Entity.
 * Here we have two child classes which inherits Vehicle class.
 * 
 * We have use JOINED strategy in which hibernate will
 * insert data of parent class in parent table and 
 * data of child class in child table.
 * 
 * After that Hibernate will insert parent key in child table
 * in order to show parent-child relationship(foreign key).
 * 
 * Analysis:
 * SINGLE TABLE : less normalized
 * TABLE_PER_CLASS : normalized but have redundancy like parent columns in all child class table
 * JOINED : highly normalized
 */
package com.github.joined.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "VEHICLE_3")
@Inheritance(strategy = InheritanceType.JOINED)
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
