package com.nagarro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="prodId")
	private int prodID;
	@Column(name="title")
	private String Title;
	@Column(name="quantity")
	private int Quantity;
	@Column(name="size")
	private String Size;
	@Column(name="image")
	private String Image;

	public Products() {
		super();
	}

	public Products(int prodID, String Title, int Quantity, String Size, String Image) {
		super();
		this.prodID = prodID;
		this.Title = Title;
		this.Quantity = Quantity;
		this.Size = Size;
		this.Image = Image;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String Size) {
		this.Size = Size;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String Image) {
		this.Image = Image;
	}

	public int getprodID() {
		return prodID;
	}

	public void setprodID(int prodID) {
		this.prodID = prodID;
	}

	@Override
	public String toString() {
		return "Products [prodID=" + prodID + ", Title=" + Title + ", Quantity=" + Quantity + ", Size=" + Size
				+ ", Image=" + Image + "]";
	}
}