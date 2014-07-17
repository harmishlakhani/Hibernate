/**
 * This class has following functionality
 * add address : this method insert data represented by Address.java in ADDRESS table
 */
package com.github.service;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.dto.Address;

public class AddressService {

	public void addaddress(Address address) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(address);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Address address = new Address();
		address.setAddressId(1);
		address.setAddressLine("This is large address.......................................");
		address.setAddressLine2("This address is not persisted.....");
		address.setDateInsterted(new Date());
		
		AddressService service = new AddressService();
		service.addaddress(address);
		
	}

}
