/**
 * This class has following functionality
 * add user : this method insert data represented by User.java
 * add vehicle : this method insert data represented by Vehicle.java
 * add relationship : insert bidirectional relationship between user and vehicle
 */
package com.github.service;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.dto.User;
import com.github.dto.Vehicle;

public class UserService {

	public void addUserVehicle(User user, Collection<Vehicle> vehicleList) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		//Setting vehicleList in User Details
		user.setVehicleList(vehicleList);
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		for(Vehicle vehicle : vehicleList)
			session.save(vehicle);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		User user = new User();
		user.setUserName("Harmish");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Honda");
		vehicle.setUser(user);
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("BMW");
		vehicle2.setUser(user);
		
		Collection<Vehicle> list = new ArrayList<Vehicle>();
		list.add(vehicle);
		list.add(vehicle2);
		
		UserService service = new UserService();
		service.addUserVehicle(user, list);
	}

}
