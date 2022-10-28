package com.nagarro.training.advancejava.assignment4.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.nagarro.training.advancejava.assignment4.model.TShirt;
@Component
public class TShirtDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<TShirt> getAllTshirt(){
		List<TShirt> tshirt = this.hibernateTemplate.loadAll(TShirt.class);
		return tshirt;
	}
}
