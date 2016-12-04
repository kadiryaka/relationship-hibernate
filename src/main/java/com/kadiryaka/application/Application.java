package com.kadiryaka.application;

import org.hibernate.Session;

import com.kadiryaka.entity.Credential;
import com.kadiryaka.entity.User;
import com.kadiryaka.entity.UserParent;

public class Application {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setName("Kadir");
		
		UserParent parent = new UserParent();
		parent.setFather("Ahmet");
		parent.setMother("Merve");
		parent.setUser(user);
		
		user.setParent(parent);

		Credential credential = new Credential();
		credential.setUsername("kyaka");
		credential.setPassword("0012");
		credential.setUser(user);
		
		
		session.save(credential);
		session.save(parent);
		session.getTransaction().commit();
		
		User dbUser = (User)session.get(User.class, user.getId());
		System.out.println("User's mothers name = " + dbUser.getParent().getMother());
		System.out.println("User's fathers name = " + dbUser.getParent().getFather());
		System.out.println("User's username and password information from User = (not access -> user.getCredential().getPassword()) " + null);
		
		Credential dbCredential = (Credential)session.get(Credential.class, credential.getId());
		System.out.println("users name from Credential relationship = " + dbCredential.getUser().getName());
		
		UserParent dbParent = (UserParent)session.get(UserParent.class, parent.getId());
		System.out.println("users name from UserParent relationship = " + dbParent.getUser().getName());
		
		session.close();
		HibernateUtil.getSessionFactory().close();
	}

}
