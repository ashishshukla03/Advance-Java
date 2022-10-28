package com.nagarro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagarro.entities.User;

public class UserDao {
	private SessionFactory factory;

	public UserDao(SessionFactory factory) {

		this.factory = factory;
	}

	public boolean getUserByEmailAndPassword(String username, String password) {
		System.out.println("hiber-connected validate");
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String query = "FROM User U WHERE U.username = :username";
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(query);
		q.setParameter("username", username);
		User user = (User) q.uniqueResult();

		if (user != null && user.getUserPassword().equals(password) && user.getUserName().equals(username)) {
			return true;
		}
		tx.commit();
		session.close();
		return false;
}}
