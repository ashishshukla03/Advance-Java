package com.AdvanceJAVA.MavenProject;
public class CSVdetails {
	private String ID;
	private String Name;
	private String Colour;
	private String gender;
	private String Size;
	
	public CSVdetails(String id, String name, String colour, String gender, String size, float price,
			float rating, String availability) {
		super();
		ID = id;
		Name = name;
		Colour = colour;
		this.gender = gender;
		Size = size;
		Price = price;
		Rating = rating;
		Availability = availability;
	}

	private float Price;
	private float Rating;
	private String Availability;
	public String getID() {
		return ID;
	}
	public void setID(String id) {
		ID = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getColour() {
		return Colour;
	}
	public void setColour(String colour) {
		Colour = colour;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public float getRating() {
		return Rating;
	}
	public void setRating(float rating) {
		Rating = rating;
	}
	public String getAvailability() {
		return Availability;
	}
	public void setAvailability(String availability) {
		Availability = availability;
	}

}
