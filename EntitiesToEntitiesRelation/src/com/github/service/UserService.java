/**
 * This class has following functionality
 * add user : this method insert data represented by User.java
 * add vehicle : this method insert data represented by Vehicle.java
 * add relationship : insert many to many relationship between user and vehicle
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

	public void addUserVehicle(Collection<User> userList, Collection<Vehicle> vehicleList) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		for(User user : userList)
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
		
		User user2 = new User();
		user2.setUserName("Prashant");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Honda");
		vehicle.getUserList().add(user);
		vehicle.getUserList().add(user2);
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("BMW");
		vehicle2.getUserList().add(user);
		vehicle2.getUserList().add(user2);
		
		Collection<User> userList = new ArrayList<User>();
		userList.add(user);
		userList.add(user2);
		
		Collection<Vehicle> vehicleList = new ArrayList<Vehicle>();
		vehicleList.add(vehicle);
		vehicleList.add(vehicle2);
		
		//Setting vehicleList in User Details
		user.setVehicleList(vehicleList);
		user2.setVehicleList(vehicleList);
				
		UserService service = new UserService();
		service.addUserVehicle(userList, vehicleList);
	}

}
