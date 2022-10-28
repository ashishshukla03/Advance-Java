package com.hibernateJDBC.HibernateJDBC;
import java.io.File;

public class TshirtThread implements Runnable{
	
	public void run() {
		boolean flag=true;
		while(flag) {
		File dir=new File("Files");
		File[]files=dir.listFiles();
		for(File file:files) {

		file.getName();
		
		}
		try {

		Thread.sleep(2000);
		}catch(InterruptedException e) {
		e.printStackTrace();
		System.out.println("File not found ");
		}
		}
		}
	
	
}

