package com.nagarro.training.advancejava.assignment4.service;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.training.advancejava.assignment4.dao.TShirtDao;
import com.nagarro.training.advancejava.assignment4.model.TShirt;

public class Search {
	
	public ArrayList<TShirt> search(TShirtDao tsd, String colour,String size, String gender, int preference){
		
		ArrayList<TShirt> result = new ArrayList<TShirt>();
		List<TShirt> list = tsd.getAllTshirt();
		
		for(TShirt itr:list) {
			if(itr.getColour().equalsIgnoreCase(colour) && itr.getSize().equalsIgnoreCase(size) && itr.getGender_Recommendation().equalsIgnoreCase(gender)) {
				result.add(itr);
			}
		}
		return result;
	}
}
