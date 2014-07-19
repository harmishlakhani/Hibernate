/**
 * This class has following functionality
 * add user : this method insert data represented by User.java
 * add vehicle : this method insert data represented by Vehicle.java
 * add relationship : insert relationship between user and vehicle
 */
package com.github.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.dto.Vehicle;
import com.github.dto.User;

public class UserService {

	public void addUserVehicle(User user, Vehicle vehicle) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		User user = new User();
		//user.setUserId(1);
		user.setUserName("Harmish");
		
		Vehicle vehicle = new Vehicle();
		//vehicle.setVehicleId(1);
		vehicle.setVehicleName("Honda");
		
		user.setVehicle(vehicle);
		
		UserService service = new UserService();
		service.addUserVehicle(user, vehicle);
	}

}
