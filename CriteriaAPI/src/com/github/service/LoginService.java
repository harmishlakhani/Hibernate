/**
 * This class has following functionality
 * 
 * read data using Criteria API.
 * We need to add restrictions to filter the records.
 * 
 */
package com.github.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.github.dto.Login;

public class LoginService {

	public void readLoginDataById(int customerId) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Login.class);
		criteria.add(Restrictions.eq("customerId", customerId));
		
		List<Login> list = criteria.list();
		
		System.out.println(list.get(0));
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LoginService service = new LoginService();
		service.readLoginDataById(25);
		
	}

}
