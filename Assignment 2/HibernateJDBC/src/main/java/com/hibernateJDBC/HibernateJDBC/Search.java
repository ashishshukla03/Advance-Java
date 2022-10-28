package com.hibernateJDBC.HibernateJDBC;
import java.util.List;
import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Search {
	public void search(String colour, String genderRecommendation, String size,int choice) throws Exception{
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TshirtInfo.class).buildSessionFactory();
    	
    	Session session = factory.openSession();
    	session.beginTransaction();
		String query="";
		
		if(choice==1) {
			query="from TshirtInfo where colour= :colour and genderRecommendation= :genderRecommendation and size= :size order by price";
		}else if(choice==2){
			query="from TshirtInfo where colour= :colour and genderRecommendation= :genderRecommendation and size= :size order by rating";
		}
		
		@SuppressWarnings("unchecked")
		Query<TshirtInfo> q= session.createQuery(query);
		q.setParameter("colour", colour);
		q.setParameter("genderRecommendation", genderRecommendation);
		q.setParameter("size", size);
		
		List<TshirtInfo> list=q.list();
		if(list.isEmpty()) {
			System.out.println("No matching T-Shirts Found");
		}else {
			System.out.println(" ");
			System.out.println("T-SHIRT INFORMATIONS:");
			System.out.println(" ");
			for(TshirtInfo f:list) {
				System.out.println("ID :" + f.getId());
				System.out.println("NAME :" + f.getName());
				System.out.println("COLOUR :" + f.getColour());
				System.out.println("Gender :"+ f.getGenderRecommendation());
				System.out.println("SIZE :"+ f.getSize());
				System.out.println("PRICE :"+ f.getPrice());
				System.out.println("RATING :"+ f.getRating());
				System.out.println("AVAILABILITY :"+ f.getAvailability());
				System.out.println(" ");
				
			}
		}
		
		session.close();
		
	}
}
