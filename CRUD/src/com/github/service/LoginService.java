/**
 * This class has following functionality
 * create login data : this method insert data represented by Login.java in LOGIN table
 * read login data : this method read the data from LOGIN table
 * update login data : this method update data in LOGIN table
 * delete login data : this method delete data from LOGIN table
 */
package com.github.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.dto.Login;

public class LoginService {

	public void createLoginData(List<Login> loginList) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		for(Login login : loginList)
			session.save(login);
		session.getTransaction().commit();
		session.close();
	}
	
	public void readLoginData(int loginId) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Login login = (Login) session.get(Login.class, loginId);
		System.out.println(login);
		
		session.getTransaction().commit();
		session.close();
	}

	public void updateLoginData(Login login) {
	
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(login);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteLoginData(Login login) {
	
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.delete(login);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LoginService service = new LoginService();
		
		//Create
		List<Login> list = new ArrayList<Login>();
		for(int i = 1; i <= 10; i++) {
			Login login = new Login();
			login.setUsername("hcl " + i);
			login.setPassword("hcl " + i);
			list.add(login);
		}
		service.createLoginData(list);
		
		//Read
		service.readLoginData(1);
		
		//Update
		Login login = new Login();
		login.setCustomerId(1);
		login.setUsername("Updated user name");
		service.updateLoginData(login);
		
		//Delete
		login.setCustomerId(10);
		service.deleteLoginData(login);
		
	}

}
