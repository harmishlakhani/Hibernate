/**
 * This class has following functionality
 * add customer data : this method insert data represented by CustomerDetail.java and Address.java in CUSTOMER_DETAIL table.
 */
package com.github.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.dto.Address;
import com.github.dto.CustomerDetail;

public class CustomerDataService {

	public void addCustomerData(CustomerDetail customer) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CustomerDetail customer = new CustomerDetail();
		customer.setCustomerId(1);
		customer.setFirstName("Harmish");
		customer.setLastName("Lakhani");
		
		Address homeAddr = new Address();
		homeAddr.setCity("Dhoraji");
		homeAddr.setCountry("India");
		homeAddr.setStreetLine("111");
		homeAddr.setPincode("360410");
		
		Address ofcAddr = new Address();
		ofcAddr.setCity("Bangalore");
		ofcAddr.setCountry("India");
		ofcAddr.setStreetLine("104");
		ofcAddr.setPincode("560037");
		
		//It can have many addresses
		customer.getAddressList().add(homeAddr);
		customer.getAddressList().add(ofcAddr);
		
		CustomerDataService service = new CustomerDataService();
		service.addCustomerData(customer);
	}

}
