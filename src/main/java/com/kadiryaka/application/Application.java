package com.kadiryaka.application;

import org.hibernate.Session;

import com.kadiryaka.entity.Credential;
import com.kadiryaka.entity.User;

public class Application {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setName("Kadir");
		
		Credential credential = new Credential();
		credential.setUsername("kyaka");
		credential.setPassword("0012");
		credential.setUser(user);
		
		session.save(credential);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtil.getSessionFactory().close();
	}

}
