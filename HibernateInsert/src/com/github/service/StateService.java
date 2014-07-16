/**
 * This class has following functionality
 * add state : this method insert data represented by State.java in STATE table
 */
package com.github.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.github.dto.State;

public class StateService {

	public void addState(State state) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(state);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		State state = new State();
		state.setStateId(1);
		state.setCountryId(1);
		state.setName("Gujarat");
		state.setAbbreviation("GJ");
		
		StateService service = new StateService();
		service.addState(state);
		
	}

}
