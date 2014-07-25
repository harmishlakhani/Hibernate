/**
 * This class has following functionality
 * 
 * read data using named query and native named query
 * 
 */
package com.github.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.dto.Login;

public class LoginService {

	public void readLoginDataByNamedQuery(int customerId) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Query query = session.getNamedQuery("Login.byId");
		query.setInteger(0, customerId);
		List<Login> list = query.list();
		
		System.out.println(list.get(0));
		session.getTransaction().commit();
		session.close();
	}

	public void readLoginDataByNativeNamedQuery(String userName) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Query query = session.getNamedQuery("Login.byName");
		query.setString(0, userName);
		List<Login> list = query.list();
		
		System.out.println(list.get(0));
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LoginService service = new LoginService();
		
		//Select by named query
		service.readLoginDataByNamedQuery(25);
		
		//Select by native named query
		service.readLoginDataByNativeNamedQuery("hcl 10");
	}

}
