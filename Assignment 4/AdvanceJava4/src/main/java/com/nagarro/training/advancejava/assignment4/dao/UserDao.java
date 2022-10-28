package com.nagarro.training.advancejava.assignment4.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nagarro.training.advancejava.assignment4.model.User;

@Component
public class UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void saveToDatabase(User user) {
		this.hibernateTemplate.save(user);
	}
	public List<User> getAllUser(){
		List<User> user = this.hibernateTemplate.loadAll(User.class);
		return user;
	}
}
