/**
 * This class has following functionality
 * add login data : this method insert data represented by Login.java in LOGIN table
 */
package com.github.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.dto.Login;
import com.github.dto.LoginForPrimaryKey;

public class LoginService {

	public void addLoginData(Login login) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(login);
		session.getTransaction().commit();
		session.close();
	}
	
	public void addLoginDataWithoutPrimaryKey(LoginForPrimaryKey login) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(login);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Login login = new Login();
		login.setCustomerId(1);
		login.setUsername("hcl");
		login.setPassword("hcl");
		
		LoginForPrimaryKey loginWithoutPrimary = new LoginForPrimaryKey();
		loginWithoutPrimary.setUsername("harmish");
		loginWithoutPrimary.setPassword("harmish");
		
		LoginService service = new LoginService();
		service.addLoginData(login);
		service.addLoginDataWithoutPrimaryKey(loginWithoutPrimary);
		
	}

}
