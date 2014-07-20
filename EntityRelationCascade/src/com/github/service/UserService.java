/**
 * This class has following functionality
 * add user : this method insert data represented by User.java
 * add vehicle : this method insert data represented by Vehicle.java
 * add relationship : insert one to many relationship between user and vehicle
 * 
 * Here we have used cascading property of OneToMany annotation in 
 * which we don't have to insert vehicle entity separately.
 * It will automatically insert user associated entities along with user.
 */
package com.github.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.dto.User;
import com.github.dto.Vehicle;

public class UserService {

	public void addUser(User user) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.persist(user);
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
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("BMW");
		
		user.getVehicleList().add(vehicle);
		user.getVehicleList().add(vehicle2);
		
		UserService service = new UserService();
		service.addUser(user);
	}

}
