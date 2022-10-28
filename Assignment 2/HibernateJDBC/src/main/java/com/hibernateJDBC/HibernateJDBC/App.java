package com.hibernateJDBC.HibernateJDBC;
import java.io.File;
import java.util.*;
public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
    	File f = new File("Files");
        Scanner sc=new Scanner(System.in);
		String colour;
		String size;
		String gender;
		int choice;
		
			while(true){
				System.out.println("Enter the colour: ");
				colour=sc.nextLine();
				String firstLetter=colour.substring(0,1);
				String remainingLetters=colour.substring(1);
				firstLetter=firstLetter.toUpperCase();
				remainingLetters=remainingLetters.toLowerCase();
				colour=firstLetter + remainingLetters;
			
				while(true) {
					try {
						System.out.println("Enter the size: ");
						size=sc.nextLine().toUpperCase();
						if(!size.equals("S") && !size.equals("M") && !size.equals("L") && !size.equals("XL") && !size.equals("XXL")) {
							throw new SizeMismatchException("This size does not exist");
						}else {
							break;
						}
					}
					catch(SizeMismatchException msg) {
						System.out.println(msg.getMessage());
					}
				}
				
				while(true) {
					try {
						System.out.println("Enter gender M or F or U: ");
						gender=sc.nextLine().toUpperCase();
						if(!gender.equals("M") && !gender.equals("F") && !gender.equals("U")) {
							throw new GenderMismatchException("Invalid Gender");
						}else {
							break;
						}
					}
					catch(GenderMismatchException msg) {
						System.out.println(msg.getMessage());
					}
				}
				
				System.out.println("Enter Output Preferene : ");
				System.out.println("1. Only by Price 2. Only by Rating");
				choice=sc.nextInt();
				
				Database data=new Database();
				
		        ArrayList<File> names=new ArrayList<File>(Arrays.asList(f.listFiles()));		        
		        for(int i=0;i<names.size();i++) {
		        	try {
						data.store(names.get(i));
					} catch (Exception e) {
						
						e.printStackTrace();
					}
		        }
		        
				TshirtThread t1=new TshirtThread();
				Thread t2=new Thread(t1);
				t2.start();
				
				Search s=new Search();
				try {
					s.search(colour,gender,size,choice);
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				sc.nextLine();
				System.out.println("Do you want to continue: Y or N");
				String yn=sc.nextLine();
			
				if(yn.equals("N") || yn.equals("n")){
					break;
    }
    }
    }
}
