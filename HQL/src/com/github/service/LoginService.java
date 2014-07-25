/**
 * This class has following functionality
 * read login data : this method read the data from LOGIN table using HQL
 * 
 * NOTE : give name of table in DB as it is in HQL otherwise you will get
 * following Exception
 * org.hibernate.hql.internal.ast.QuerySyntaxException: table is not mapped
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

	public void readLoginData() {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from LOGIN where customerId > 25");
		List<Login> list = query.list();
		
		System.out.println("No of records : " + list.size());
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
		
		//Select
		service.readLoginData();
		
	}

}
