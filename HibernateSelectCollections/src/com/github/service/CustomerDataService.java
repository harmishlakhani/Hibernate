/**
 * This class has following functionality
 * add customer data : this method insert data represented by CustomerDetail.java and Address.java in CUSTOMER_DETAIL table.
 */
package com.github.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.dto.CustomerDetail;

public class CustomerDataService {

	public void getCustomerData(int customerId) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		CustomerDetail customer = (CustomerDetail) session.get(CustomerDetail.class, customerId);
		System.out.println(customer);
		session.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CustomerDataService service = new CustomerDataService();
		
		//Hibernate will fetch all the data for customer id 1.
		//Here addressSet is fetched because of Eager loading but addressList is fetched only when we call getter of it.
		service.getCustomerData(1);
	}

}
