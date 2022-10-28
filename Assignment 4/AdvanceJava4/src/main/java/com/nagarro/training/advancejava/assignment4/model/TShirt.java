package com.nagarro.training.advancejava.assignment4.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tshirt")
public class TShirt {
	
	@Id
	private String id;
	private String name;
	private String colour;
	private String gender_Recommendation;
	private String size;
	private float price;
	private float rating;
	private String availability;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getGender_Recommendation() {
		return gender_Recommendation;
	}
	public void setGender_Recommendation(String gender_Recommendation) {
		this.gender_Recommendation = gender_Recommendation;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "TShirt [id=" + id + ", name=" + name + ", colour=" + colour + ", gender_Recommendation="
				+ gender_Recommendation + ", size=" + size + ", price=" + price + ", rating=" + rating
				+ ", availability=" + availability + "]";
	}
	
	
}
