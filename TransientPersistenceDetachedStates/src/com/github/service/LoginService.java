/**
 * This class shows demo of how transient, persistence and detached state works.
 * 
 * TRANSIENT : Until session is opened all the objects are in transient state.
 * 
 * PERSISTENCE : Once we give object to session in order to save that in DB object 
 * 				 come to persistence state. When we close the session hibernate
 * 				 will update all the changes that we have done in that persistence object.
 * 
 * DETACHED : After closing the session object comes to detached state in which if
 * 			  we make any changes hibernate doesn't update that in DB.
 */
package com.github.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.dto.Login;

public class LoginService {

	public void createLoginData() {
		
		//Transient State starts
		Login login = new Login();
		login.setUsername("Create : Login is in transient state");
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		//Transient State ends

		//Persistence state starts
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(login);
		
		login.setUsername("Create : Login is in persistence state"); //update the DB because it is in persistence state.
		session.getTransaction().commit();
		session.close();
		//Persistence state ends
		
		//Detached state starts
		login.setUsername("Create : Login is in detached state");
		//Detached state ends
	}
	
	public void readLoginData() {
		
		//Transient State starts
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		//Transient State ends

		//Persistence state starts
		Session session = factory.openSession();
		session.beginTransaction();
		
		Login login = (Login) session.get(Login.class, 1);
		System.out.println(login);
		
		login.setUsername("Read : Login is in persistence state"); //update the DB because it is in persistence state.
		session.getTransaction().commit();
		session.close();
		//Persistence state ends
		
		//Detached state starts
		login.setUsername("Read : Login is in detached state");
		//Detached state ends
	}
	
	public void deleteLoginData() {
		
		//Transient State starts
		Login login = new Login();
		login.setCustomerId(1);
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		//Transient State ends

		//Persistence state starts
		Session session = factory.openSession();
		session.beginTransaction();
		session.delete(login);
		//After deleting login goes into transient state so if we change anything then also 
		//it is not going to be persisted because record is deleted from the DB
		login.setUsername("Delete : Login is in persistence state");
		session.getTransaction().commit();
		session.close();
		//Persistence state ends
		
		//Detached state starts
		login.setUsername("Delete : Login is in detached state");
		//Detached state ends
	}
	
	public void detachedToPersistence() {
		
		//Fetch the data
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		session.beginTransaction();
		
		Login login = (Login) session.get(Login.class, 1);
		System.out.println(login);
		
		session.getTransaction().commit();
		session.close();
		
		//login goes into detached state
		
		//Make some changes like updating some properties according
		//to user needs
		
		login.setUsername("Changes made during detached state");
		session = factory.openSession();
		session.beginTransaction();
		
		//This convert login from detached to persistence state again.
		session.update(login);
		//any changes made into login is updated in DB because of persistence state of login
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LoginService service = new LoginService();
		//service.createLoginData();
		//service.readLoginData();
		//service.deleteLoginData();
		service.detachedToPersistence();
	}

}
