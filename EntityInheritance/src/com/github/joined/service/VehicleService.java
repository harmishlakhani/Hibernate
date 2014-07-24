/**
 * This class has following functionality
 * add user : this method insert data represented by User.java
 * add vehicle : this method insert data represented by Vehicle.java
 * add relationship : insert bidirectional relationship between user and vehicle
 */
package com.github.joined.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.joined.dto.FourWheelerVehicle;
import com.github.joined.dto.TwoWheelerVehicle;
import com.github.joined.dto.Vehicle;

public class VehicleService {

	public void addVehicle(Vehicle vehicle, TwoWheelerVehicle twoWheelerVehicle, FourWheelerVehicle fourWheelerVehicle) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(twoWheelerVehicle);
		session.save(fourWheelerVehicle);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Hcl's Vehicle");
		
		TwoWheelerVehicle twoWheelerVehicle = new TwoWheelerVehicle();
		twoWheelerVehicle.setVehicleName("Hero");
		twoWheelerVehicle.setStreeingHandle("Splendar's handle");
		
		FourWheelerVehicle fourWheelerVehicle = new FourWheelerVehicle();
		fourWheelerVehicle.setVehicleName("Honda");
		fourWheelerVehicle.setStreeingWheel("HondaCivic's wheel");
		
		VehicleService service = new VehicleService();
		service.addVehicle(vehicle, twoWheelerVehicle, fourWheelerVehicle);
	}

}
