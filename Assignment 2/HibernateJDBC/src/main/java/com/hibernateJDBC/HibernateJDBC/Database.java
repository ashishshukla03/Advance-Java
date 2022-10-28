package com.hibernateJDBC.HibernateJDBC;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Database {
	public void store(File filename) throws Exception{
		try {
			
			
			FileReader reader = new FileReader(filename);
	    	reader.read(); 
	    	Iterable <CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().withIgnoreHeaderCase().withQuote('"').withDelimiter('|').parse(reader);
	    	
	    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(TshirtInfo.class).buildSessionFactory();
	    	
	    	Session session = factory.openSession();
	    	session.beginTransaction();
	    	
	    	for(CSVRecord record : records) {
	    		TshirtInfo info = new TshirtInfo();
	    		info.setId(record.get(0));
	    		info.setName(record.get(1));
	    		info.setColour(record.get(2));
	    		info.setGenderRecommendation(record.get(3));
	    		info.setSize(record.get(4));
	    		info.setPrice(Float.parseFloat(record.get(5).trim()));
	    		info.setRating(Float.parseFloat(record.get(6)));
	    		info.setAvailability(record.get(7));
	    		
	    		session.save(info);
	    		}
	    		session.getTransaction().commit();
	    		session.close();
	    		
	    		
			}catch(FileNotFoundException e) {
	        	e.printStackTrace();
		        } catch(IOException e) {
		        	e.printStackTrace();
		        }
		
	}

}
