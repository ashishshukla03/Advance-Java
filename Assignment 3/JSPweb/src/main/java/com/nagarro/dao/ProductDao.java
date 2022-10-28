package com.nagarro.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagarro.entities.Products;

public class ProductDao {
	private SessionFactory factory;

	public ProductDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public Products storeProduct(String title, int quantity, String size, String image) {
		Products prod = null;
		try {
			String query = "insert into products (Image, Quantity,Size,Title)";
			Session session = this.factory.openSession();

			@SuppressWarnings("rawtypes")
			Query q = session.createQuery(query);
			q.setParameter("Title", title);
			q.setParameter("Quantity", quantity);
			q.setParameter("Size", size);
			q.setParameter("Image", image);
			System.out.println("product content is stored");
			session.close();

		} catch (Exception e) {
		}
		return prod;
	}

	public boolean saveProduct(Products prod) {
		boolean f = false;
		try {
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(prod);
			System.out.println("product is saved");
			tx.commit();
			session.close();
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
			f = false;
		}
		return f;
	}

	@SuppressWarnings("unchecked")
	public List<Products> getProducts() {
		Session session = factory.openSession();
		Query<Products> query = session.createQuery("from Products");
		List<Products> list = query.list();
		return list;
	}

	public void deleteProduct(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Products prod = session.get(Products.class, id);
			session.delete(prod);
			System.out.println("product is deleted");
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public Products getSingleProduct(int id) {
		Products prod = null;
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String query = "select * from products where id=? ";
			prod = session.get(Products.class, id);
			@SuppressWarnings({ "rawtypes" })
			Query q = session.createQuery(query);
			q.setParameter("ProdId", id);
			tx.commit();
			session.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			;
		}
		return prod;
	}

	public void updateProduct(Products prod) {
		Session s = this.factory.openSession();
		Transaction tx = s.beginTransaction();
		try {
			s.update(prod);
			System.out.println("product is updated");
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}
