/**
 * This class has following functionality
 * add country : this method insert data represented by Country.java in Country table
 */
package com.github.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.dto.Country;

public class CountryService {

	public void addCountry(Country country) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(country);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Country country = new Country();
		country.setCountryId(1);
		country.setCountryDesc("India");
		country.setIsoCode("IN");
		
		CountryService service = new CountryService();
		service.addCountry(country);
		
	}

}
