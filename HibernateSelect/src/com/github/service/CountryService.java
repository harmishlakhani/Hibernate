/**
 * This class has following functionality
 * get country : this method return selected data from Country table.
 */
package com.github.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.dto.Country;

public class CountryService {

	public Country getCountry(int countryId) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		Country country = (Country) session.get(Country.class, countryId);
		session.close();
		
		return country;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Country country = null;
		
		CountryService service = new CountryService();
		country = service.getCountry(1);
		
		System.out.println("Country " + country.getCountryDesc() + " : " + country.getIsoCode());
		
	}

}
