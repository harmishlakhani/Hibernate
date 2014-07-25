/**
 * This class has following functionality
 * 
 * Read data using Criteria API.
 * We need to add restrictions to filter the records.
 * We can give AND and OR condition in where clause using Restrictions.or()/and().
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

	public void readLoginData() {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Login.class);
		criteria.add(Restrictions.or(Restrictions.like("username", "hcl"), Restrictions.gt("customerId", 25)));
		
		List<Login> list = criteria.list();
		for(Login login : list)
			System.out.println(login);
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LoginService service = new LoginService();
		service.readLoginDataById(25);
		service.readLoginData();
	}

}
