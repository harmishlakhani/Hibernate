/**
 * This class has following functionality
 * 
 * read login data : this method read the data from LOGIN table using HQL
 * NOTE : give name of table in DB as it is in HQL otherwise you will get
 * following Exception
 * org.hibernate.hql.internal.ast.QuerySyntaxException: table is not mapped
 * 
 * read login data with pagination : read data from DB for selected chunk only
 * 
 * read login data with selected columns : sometimes we don't need all the 
 * columns. we are interested in selected columns only so give name of the 
 * columns that you need in select statement of HQL.
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
	 * This method fetches only selected records for one page
	 * We need to pass how many records we need using limit parameter
	 * and starting point so that hibernate fetches only that many records.
	 * 
	 * @param startPoint
	 * @param limit
	 */
	public void readLoginDataWithPagination(int startPoint, int limit) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from LOGIN");
		query.setFirstResult(startPoint);
		query.setMaxResults(limit);
		List<Login> list = query.list();
		
		System.out.println("No of records in one page: " + list.size());
		for(Login login : list)
			System.out.println(login);
		session.getTransaction().commit();
		session.close();
	}

	public void readLoginDataWithSelectedColumns() {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("select username from LOGIN");
		List<String> list = query.list();
		
		System.out.println("No of records : " + list.size());
		for(String login : list)
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
		
		//Select for pagination
		service.readLoginDataWithPagination(5, 5);
		
		//Select some columns only
		service.readLoginDataWithSelectedColumns();
	}

}
