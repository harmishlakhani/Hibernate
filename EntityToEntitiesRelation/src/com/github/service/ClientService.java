/**
 * This class has following functionality
 * add client : this method insert data represented by Client.java
 * add address : this method insert data represented by Address.java
 * add relationship : insert bidirectional relationship between client and address
 */
package com.github.service;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.dto.Client;
import com.github.dto.Address;

public class ClientService {

	public void addClientAddress(Client client, Collection<Address> addressList) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		//Setting addressList in Client Details
		client.setAddressList(addressList);
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(client);
		for(Address address : addressList)
			session.save(address);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Client client = new Client();
		client.setClientName("Harmish");
		
		Address address = new Address();
		address.setStreetName("Patoliya Street");
		address.setClient(client);
		
		Address address2 = new Address();
		address2.setStreetName("Love Street");
		address2.setClient(client);
		
		Collection<Address> list = new ArrayList<Address>();
		list.add(address);
		list.add(address2);
		
		ClientService service = new ClientService();
		service.addClientAddress(client, list);
	}

}
